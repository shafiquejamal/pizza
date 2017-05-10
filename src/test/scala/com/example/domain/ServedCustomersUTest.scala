package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class ServedCustomersUTest extends FlatSpec with ShouldMatchers {
  
  "The average wait time for served customers" should "be 0 if there are no served customers, and the total time " +
  "divided by the number of customers, otherwise" in {
    
    val noServedCustomers = ServedCustomers(Seq())
    noServedCustomers.averageWaitTime shouldBe 0
    
    val c0 = Customer(ArrivalTime(0), OrderProcessingTime(3))
    val c1 = Customer(ArrivalTime(1), OrderProcessingTime(9))
    val c2 = Customer(ArrivalTime(2), OrderProcessingTime(6))
    
    val sC0 = ServedCustomer(c0, 3)
    val sC2 = ServedCustomer(c2, 7)
    val sC1 = ServedCustomer(c1, 17)
    
    val servedCustomers = ServedCustomers(Seq(sC0, sC2, sC1))
    servedCustomers.averageWaitTime shouldEqual 9
  }
  
}
