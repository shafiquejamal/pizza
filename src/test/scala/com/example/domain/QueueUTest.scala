package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class QueueUTest extends FlatSpec with ShouldMatchers {
  
  "The queue" should "be able to figure out which customers have already arrived" in new CustomerFixture {
    
    Queue(customers, Time(1.5), noServedCustomers).visibleCustomers should contain theSameElementsAs Seq(c0, c1)
    Queue(customers, Time(1), noServedCustomers).visibleCustomers should contain theSameElementsAs Seq(c0, c1)
    Queue(customers, Time(0), noServedCustomers).visibleCustomers should contain theSameElementsAs Seq(c0)
    
  }
  
}
