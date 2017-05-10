package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class ServedCustomersUTest extends FlatSpec with ShouldMatchers {
  
  "The average wait time for served customers" should "be 0 if there are no served customers, and the total time " +
  "divided by the number of customers, otherwise" in new CustomerFixture {
    
    noServedCustomers.averageWaitTime shouldBe 0
    servedCustomers1.averageWaitTime shouldEqual 9
  }
  
}
