package com.example.entrypoint

import com.example.domain.{Cook, Reader}

object Main extends App {
  
  val customers = Reader read args(0)
  println("---------------------------------------------")
  println("Customer(arrival time, order processing time)")
  println("---------------------------------------------")
  customers.foreach(println)
  println("---------------------------------------------")
  
  val servedCustomers = Cook serve customers
  
  println(s"Served customers:")
  println("---------------------------------------------")
  servedCustomers.served.foreach { servedCustomer =>
    println(s"${servedCustomer.customer.arrivalTime}, waited: ${servedCustomer.timeWaited}") }
  println(s"The average wait time (integer part only): ${servedCustomers.averageWaitTime}")
  println("---------------------------------------------")
}
