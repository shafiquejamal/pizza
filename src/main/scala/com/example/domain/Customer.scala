package com.example.domain

case class ArrivalTime(t: Double) {
  
  def isOnOrBefore(that: ArrivalTime): Boolean = t <= that.t
  
}

case class OrderProcessingTime(pt: Double) extends AnyVal

case class Customer(arrivalTime: ArrivalTime, orderProcessingTime: OrderProcessingTime)

case class ServedCustomer(customer: Customer, timeWaited: Double)

case class ServedCustomers(served: Seq[ServedCustomer]) {
  
  def averageWaitTime:Int =
    if (served.nonEmpty)
      (served.map(_.timeWaited).sum / served.length).toInt
    else
      0
  
}

