package com.example.domain

trait CustomerFixture {
  
  val c0 = Customer(Time(0), OrderProcessingTime(3))
  val c1 = Customer(Time(1), OrderProcessingTime(9))
  val c2 = Customer(Time(2), OrderProcessingTime(6))
  
  val sC0 = ServedCustomer(c0, 3)
  val sC2 = ServedCustomer(c2, 7)
  val sC1 = ServedCustomer(c1, 17)
  
  val customers = Seq(c2, c1, c0)
  val noServedCustomers = ServedCustomers(Seq())
  
  val servedCustomers = ServedCustomers(Seq(sC0, sC2, sC1))
  
}
