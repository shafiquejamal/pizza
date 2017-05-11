package com.example.domain

import scala.annotation.tailrec

object Cook {
  
  def serve(customers: Seq[Customer]): ServedCustomers = {
    val queue = Queue(customers, Time(0), ServedCustomers(Seq()))
    process(queue).servedCustomers
  }
  
  @tailrec
  def process(queue: Queue): Queue = {
    if (queue.customers.isEmpty) {
      queue
    } else if (queue.visibleCustomers.isEmpty) {
      process(waitForNextCustomer(queue))
    } else {
      process(processNextCustomer(queue))
    }
  }

  def waitForNextCustomer(queue: Queue): Queue = {
    if (queue.visibleCustomers.nonEmpty || queue.customers.isEmpty) {
      queue
    } else {
      val nextCustomerArrival = queue.customers.map(_.arrivalTime.t).min
      queue.copy(currentTime = Time(nextCustomerArrival))
    }
  }
  
  def processNextCustomer(queue: Queue): Queue = {
    val lowestPizzaMakingTime = queue.visibleCustomers.map(_.orderProcessingTime).min
    val maybeNextCustomer = queue.visibleCustomers.find(_.orderProcessingTime == lowestPizzaMakingTime)
    maybeNextCustomer.fold {
      queue
    } { customer =>
      val newTime = queue.currentTime + customer.orderProcessingTime
      val newVisibleCustomers = queue.visibleCustomers(newTime).filterNot{ c => c == customer }
      val customerWaitTime = newTime - customer.arrivalTime
      val newServedCustomers = queue.servedCustomers + ServedCustomer(customer, customerWaitTime)
      Queue(newVisibleCustomers, newTime, newServedCustomers)
    }
  }
  
}
