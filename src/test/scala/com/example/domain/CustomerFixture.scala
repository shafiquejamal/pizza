package com.example.domain

trait CustomerFixture {
  
  val c0 = Customer(Time(0), OrderProcessingTime(3))
  val c1 = Customer(Time(1), OrderProcessingTime(9))
  val c2 = Customer(Time(2), OrderProcessingTime(6))
  val c2b = Customer(Time(2), OrderProcessingTime(5))
  
  val sC0 = ServedCustomer(c0, 3)
  val sC2 = ServedCustomer(c2, 7)
  val sC2b = ServedCustomer(c2b, 6)
  val sC1 = ServedCustomer(c1, 17)
  val sC1b = ServedCustomer(c1, 16)
  
  val customers1 = Seq(c2, c1, c0)
  val customers2 = Seq(c1, c2b, c0)
  val noServedCustomers = ServedCustomers(Seq[ServedCustomer]())
  
  val servedCustomers1 = ServedCustomers(Seq(sC0, sC2, sC1))
  val servedCustomers2 = ServedCustomers(Seq(sC0, sC2b, sC1b))
  
  val qSampleInput1 = Queue(customers1, Time(0), noServedCustomers)
  val qSampleInput2 = Queue(customers2, Time(0), noServedCustomers)
  
}
