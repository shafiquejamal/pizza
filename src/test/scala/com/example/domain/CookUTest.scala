package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class CookUTest extends FlatSpec with ShouldMatchers {

  "Waiting for the next customer" should "advance the current time to the arrival time of the customer in the queue " +
  "that will arrive next, if there are no visible customers" in new CustomerFixture {
  
    val q = Queue(customers1, Time(-1), noServedCustomers)
    Cook.waitForNextCustomer(q) shouldEqual Queue(customers1, Time(0), noServedCustomers)
    Cook.waitForNextCustomer(q.copy(currentTime = Time(1.5))) shouldEqual Queue(customers1, Time(1.5), noServedCustomers)
  
    val customersLastOneOnly = customers1.filterNot(customer => customer == c0 || customer == c1)
    val qOneCustomer = Queue(customersLastOneOnly, Time(0.5), ServedCustomers(sC0))
    Cook.waitForNextCustomer(qOneCustomer) shouldEqual qOneCustomer.copy(currentTime = Time(2))
    
  }

  "Processing the next customer" should "select the customer with the shortest order processing time, advance the " +
  "time by that amount, calculate the customers wait time, then move that customers to the served customers list" in
  new CustomerFixture {
  
    val qExpectedAfterFirstServed = Queue(customers1.filterNot(_ == c0), Time(3), ServedCustomers(ServedCustomer(c0, 3)))
    Cook.processNextCustomer(qSampleInput1) shouldEqual qExpectedAfterFirstServed
  
  }
  
  "Processing a queue" should "return the queue as is if it contains no customers to process" in new CustomerFixture {

    val qNoMoreCustomers = Queue(Seq(), Time(0), servedCustomers1)
    Cook.process(qNoMoreCustomers) shouldEqual qNoMoreCustomers
  
  }
  
  it should "process all of the customers in the queue" in new CustomerFixture {
    
    Cook.process(qSampleInput1) shouldEqual Queue(Seq(), Time(18), servedCustomers1)
    Cook.process(qSampleInput2) shouldEqual Queue(Seq(), Time(17), servedCustomers2)
  
  }
  
  "Serving all the customers" should "yield the correct average wait time" in new CustomerFixture {
    
    Cook serve qSampleInput1.customers shouldEqual 9
    Cook serve qSampleInput2.customers shouldEqual 8
    
  }
  
}
