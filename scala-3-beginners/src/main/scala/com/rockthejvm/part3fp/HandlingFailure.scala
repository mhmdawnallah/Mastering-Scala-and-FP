package com.rockthejvm.part3fp

import scala.util.{Success, Try}
/**
 * 1) Try indicates a potentially failed computation
 * 2) In Scala, Try is a type that represents the result of an operation that may throw an exception. It is similar to Option, but instead of representing the presence or absence of a value, it represents the success or failure of an operation, and can contain either a value or an exception.
      When writing pure functions with Try, the goal is to create functions that do not have side effects and do not throw exceptions, but instead return a Try value that represents the success or failure of the operation. This can help you write more robust and testable code, and handle errors in a more structured way.
 * 3)
 */
object HandlingFailure {
  def main(args: Array[String]): Unit = {
    testTrys()

  }

  def testTrys(): Unit = {
    val aTry: Try[Int] = Try(42)
    val aFailedTry: Try[Int] = Try(throw new RuntimeException)
    val anIncrementedTry = aTry.map(_ + 1)
    val anIncrementedFailureTry = aFailedTry.map(_ + 1)
    val tenByTwo = divide(10, 2).fold(
      error => s"Error: $error",
      result => s"Result: $result"
    )
    val tenByZero = divide(10, 0).fold(
      error => s"Error: $error",
      result => s"Result: $result"
    )
    assert(aTry.isSuccess)
    assert(aFailedTry.isFailure)
    assert(anIncrementedTry == Success(43))
    assert(anIncrementedFailureTry.isFailure)
    assert(tenByTwo == "Result: 5")
    assert(tenByZero == "Error: java.lang.ArithmeticException: / by zero")
  }

  def divide(a: Int, b: Int): Try[Int] =
    Try(a / b)

}
