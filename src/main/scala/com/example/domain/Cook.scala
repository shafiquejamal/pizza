package com.example.domain

object Cook {
  
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
  
  def processNextCustomer(queue: Queue): Queue = ???
  
}
