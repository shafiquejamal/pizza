package com.example.domain

case class Time(t: Double) {
  
  def isOnOrBefore(that: Time): Boolean = t <= that.t
  
  def -(that: Time): Double = {
    val difference = t - that.t
    BigDecimal(difference).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def +(orderProcessingTime: OrderProcessingTime): Time = {
    val sum = t + orderProcessingTime.pt
    Time(BigDecimal(sum).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
  }
  
}

case class OrderProcessingTime(pt: Double) extends Ordered[OrderProcessingTime] {
  
  override def compare(that: OrderProcessingTime) = pt.compareTo(that.pt)
  
}

case class Customer(arrivalTime: Time, orderProcessingTime: OrderProcessingTime)

case class ServedCustomer(customer: Customer, timeWaited: Double)

case class ServedCustomers(served: Seq[ServedCustomer]) {
  
  def averageWaitTime: Int =
    if (served.nonEmpty)
      (served.map(_.timeWaited).sum / served.length).toInt
    else
      0
  
  def +(servedCustomer: ServedCustomer): ServedCustomers = {
    ServedCustomers(served :+ servedCustomer)
  }
  
}

object ServedCustomers {
  
  def apply(servedCustomer: ServedCustomer): ServedCustomers = ServedCustomers(Seq(servedCustomer))
  
}

case class Queue(customers: Seq[Customer], currentTime: Time, servedCustomers: ServedCustomers) {
  
  def visibleCustomers: Seq[Customer] = visibleCustomers(currentTime)
  
  def visibleCustomers(newTime: Time): Seq[Customer] = customers.filter( _.arrivalTime isOnOrBefore newTime )
  
}

