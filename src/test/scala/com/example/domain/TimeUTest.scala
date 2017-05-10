package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class TimeUTest extends FlatSpec with ShouldMatchers {
  
  "Whether arrival time A is on or before arrival time B" should "be true if arrival time a is less than or equal to" +
  "arrival time B" in {
    
    val arrivalTimeEarliest = Time(0)
    val arrivalTimeMid = Time(5)
    val arrivalTimeLatest = Time(10)
    
    arrivalTimeMid isOnOrBefore arrivalTimeMid shouldBe true
    arrivalTimeMid isOnOrBefore arrivalTimeEarliest shouldBe false
    arrivalTimeEarliest isOnOrBefore arrivalTimeMid shouldBe true
    arrivalTimeLatest isOnOrBefore arrivalTimeMid shouldBe false
  }
  
  "Subtracting two times" should "yield the correct difference" in {
    Time(5.3) - Time(3.6) shouldEqual 1.7
  }
  
  "Adding order processing time" should "advance the time by the amount of the order processing time" in {
    Time(2.8) + OrderProcessingTime(9.7) shouldEqual Time(12.5)
  }
  
}
