package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class ArrivalTimeUTest extends FlatSpec with ShouldMatchers {
  
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
  
}
