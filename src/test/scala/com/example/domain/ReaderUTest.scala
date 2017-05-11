package com.example.domain

import org.scalatest.{FlatSpec, ShouldMatchers}

class ReaderUTest extends FlatSpec with ShouldMatchers {
  
  "The Reader" should "convert the text file to a collection of customer data" in new CustomerFixture {
    
    Reader.read("src/test/resources/SampleInput1.txt") should contain theSameElementsAs customers1
    
  }
  
}
