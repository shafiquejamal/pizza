package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class ArrivalTimeUTest extends FlatSpec with ShouldMatchers {
  
  "Whether arrival time A is on or before arrival time B" should "be true if arrival time a is less than or equal to" +
  "arrival time B" in {
    
    val aTEarliest = ArrivalTime(0)
    val atMid = ArrivalTime(5)
    val aTLatest = ArrivalTime(10)
    
    atMid isOnOrBefore atMid shouldBe true
    atMid isOnOrBefore aTEarliest shouldBe false
    aTEarliest isOnOrBefore atMid shouldBe true
    aTLatest isOnOrBefore atMid shouldBe false
  }
  
}
