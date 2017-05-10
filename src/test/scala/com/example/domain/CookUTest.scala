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

  "Processing the next customer" should "select the customer with the shortest order processing time, advance the " +
  "time by that amount, calculate the customers wait time, then move that customers to the served customers list" in
  new CustomerFixture {
  
    val q = Queue(customers, Time(0), noServedCustomers)
    val qExpectedAfterFirstServed = Queue(customers.filterNot(_ == c0), Time(3), ServedCustomers(ServedCustomer(c0, 3)))
    Cook.processNextCustomer(q) shouldEqual qExpectedAfterFirstServed
  
  }
  
}
