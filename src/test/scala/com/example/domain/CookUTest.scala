package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class CookUTest extends FlatSpec with ShouldMatchers {

  "Waiting for the next customer" should "advance the current time to the arrival time of the customer in the queue " +
  "that will arrive next, if there are no visible customers" in new CustomerFixture {
  
    val q = Queue(customers, Time(-1), noServedCustomers)
    Cook.waitForNextCustomer(q) shouldEqual Queue(customers, Time(0), noServedCustomers)
    Cook.waitForNextCustomer(q.copy(currentTime = Time(1.5))) shouldEqual Queue(customers, Time(1.5), noServedCustomers)
  
    val customersLastOneOnly = customers.filterNot(customer => customer == c0 || customer == c1)
    val qOneCustomer = Queue(customersLastOneOnly, Time(0.5), ServedCustomers(sC0))
    Cook.waitForNextCustomer(qOneCustomer) shouldEqual qOneCustomer.copy(currentTime = Time(2))
    
  }

}
