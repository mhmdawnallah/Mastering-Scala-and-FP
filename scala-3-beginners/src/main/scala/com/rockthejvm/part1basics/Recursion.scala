package com.rockthejvm.part1basics

import scala.annotation.tailrec

/**
 * 1) Tail Recursion is very optimized for Scala Compiler as it re-uses the same stack frame of the function invocation so no more stackoverflow unlike stack recursion (non-tail recursion)
 */
object Recursion {

  def sumUntil(number: Int): Int = {
    if (number <= 0) 0
    else number + sumUntil(number-1)
  }

  def sumUntilTailRecursion(number: Int): Int = {
    @tailrec
    def sumUntilHelper(n: Int, accumlator: Int): Int = {
      if (n <= 0) accumlator
      else sumUntilHelper(n - 1, accumlator + n)
    }
    sumUntilHelper(number, 0)
  }

  def sumBetween(a: Int, b: Int): Int = {
    if (a == b) b
    else a + sumBetween(a + 1, b)
  }

  def sumBetweenTailRecursion(a: Int, b: Int): Int = {
    @tailrec
    def sumBetweenHelper(a: Int, b: Int, accumlator: Int): Int = {
      if (accumlator == b) accumlator + b
      else sumBetweenHelper(a, b, accumlator + 1 )
    }
    sumBetweenHelper(a, b, a)
  }

  def getFactorialTailRecursion(number: Int): Int = {
    @tailrec
    def getFactorialHelper(number: Int, accumlator: Int): Int = {
      if (number <= 0) 0
      else if (number == 1) accumlator
      else getFactorialHelper(number - 1, accumlator * number)
    }
    getFactorialHelper(number, 1)
  }

  def getFibanocci(n: Int): Int = {
    if (n <= 1) n
    else getFibanocci(n - 1) + getFibanocci(n - 2)
  }

  def getFibanocciTailRecursion(number: Int): Int = {
    @tailrec
    def getFibanocciHelper(number: Int, previous: Int, current: Int): Int = {
      if (number == 0) previous
      else getFibanocciHelper(number - 1, current, previous + current)
    }
    getFibanocciHelper(number, 0, 1)
  }

  def concatenateStringTailRecursion(str: String, times: Int): String = {
    @tailrec
    def concatenateStringHelper(times: Int, accumlator: String): String = {
      if (times == 0) accumlator
      else concatenateStringHelper(times - 1, accumlator + str)
    }
    concatenateStringHelper(times, "")
  }

  def isPrimeTailRecursion(number: Int): Boolean = {
    @tailrec
    def isPrimeHelper(counter: Int = 2): Boolean = {
      if (number <= 1) false
      else if (counter == number) true
      else if (number % counter == 0) false
      else isPrimeHelper(counter + 1)
    }

    isPrimeHelper()
  }


  def main(args: Array[String]): Unit = {
    val number: Int = 6
    val sumUntilResult: Int = sumUntil(number)
    val sumUntilTailRecursionResult: Int = sumUntilTailRecursion(number)
    assert(sumUntilTailRecursionResult == sumUntilResult)
    val sumBetweenResult: Int = sumBetween(1, 3)
    assert(sumBetweenResult == 6)
    val sumBetweenTailRecursionResult: Int = sumBetweenTailRecursion(1, 3)
    assert(sumBetweenTailRecursionResult == 6)
    val factorialTailRecursionResult: Int = getFactorialTailRecursion(4)
    assert(factorialTailRecursionResult == 24)
    val fibanocciTailRecursionResult: Int = getFibanocciTailRecursion(3)
    assert(fibanocciTailRecursionResult == 2)
    val concatenateStringResult: String = concatenateStringTailRecursion("Scala", 3)
    assert(concatenateStringResult == "ScalaScalaScala")
    val isPrimeTailRecursionResult: Boolean = isPrimeTailRecursion(3)
    assert(isPrimeTailRecursionResult == true)
  }
}
