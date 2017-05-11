package com.example.domain

object Reader {

  def read(path: String): Seq[Customer] = {
    // Source: http://alvinalexander.com/scala/csv-file-how-to-process-open-read-parse-in-scala
    val bufferedSource = io.Source.fromFile(path)
    val customers = (for (line <- bufferedSource.getLines.drop(1) ) yield {
      val Array(arrivalTime, orderProcessingTime) = line.split("""\s""").map(_.trim)
      Customer(Time(arrivalTime.toDouble), OrderProcessingTime(orderProcessingTime.toDouble))
    }).toVector
    bufferedSource.close
    customers
  }
  
}
