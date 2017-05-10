package com.example.domain

case class Time(t: Double) {
  
  def isOnOrBefore(that: Time): Boolean = t <= that.t
  
}

case class OrderProcessingTime(pt: Double) extends AnyVal

case class Customer(arrivalTime: Time, orderProcessingTime: OrderProcessingTime)

case class ServedCustomer(customer: Customer, timeWaited: Double)

case class ServedCustomers(served: Seq[ServedCustomer]) {
  
  def averageWaitTime: Int =
    if (served.nonEmpty)
      (served.map(_.timeWaited).sum / served.length).toInt
    else
      0
  
}

object ServedCustomers {
  
  def apply(servedCustomer: ServedCustomer): ServedCustomers = ServedCustomers(Seq(servedCustomer))
  
}

case class Queue(customers: Seq[Customer], currentTime: Time, servedCustomers: ServedCustomers) {
  
  def visibleCustomers: Seq[Customer] = customers.filter( customer => customer.arrivalTime isOnOrBefore currentTime )
  
}

