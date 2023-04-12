package com.rockthejvm.part1basics

import scala.annotation.tailrec

/**
 * 1) Scala is a Functional programming language that applies Immutability which means that once a value is assigned to a variable, it cannot be changed.
 * This makes it easier to reason about code and prevents unexpected side effects.
 * 2) Avoid effects in the Pure Functions e.g Scala
 */
object Functions {

  def calculateSum(number1: Int, number2: Int): Int = number1 + number2

  def getNumber(): Int = 45
  def getNumberParameterless: Int = 45

  def concatenateString(str: String, times: Int): String = {
    if (times == 0) ""
    else str + concatenateString(str, times - 1)
  }

  def printString(string: String): Unit =
    println(string)

  def getDoubledStringWithPrintingString(string: String): String = {
    // NOT RECOMMENDED because printString creates side effect even if it's just printing to the stdout
    printString(string)
    string + string
  }

  def computeCalculation(number1: Int, number2: Int): Int = {
    def computeCalculationHelper(n1: Int, n2: Int): Int = {
      n1 * n1 * n2 * n2
    }
    computeCalculationHelper(number1, number2)
  }

  def greet(name: String, age: Int): Unit =
    println("Hi, My name is " + name + " and I am " + age + " years old")

  def getFactorial(number: Int): Int = {
    if (number <= 0) 0
    else if (number == 1)  1
    else number * getFactorial(number - 1)
  }

  def getFibanocci(n: Int): Int = {
    if (n <= 1) n
    else getFibanocci(n - 1) + getFibanocci(n - 2)
  }

  def isPrime(number: Int): Boolean = {
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
    val number1: Int = 3
    val number2: Int = 2
    val sum: Int = calculateSum(number1, number2)
    assert(sum == 5, "Sum is not equal to 5")
    val number:Int = getNumber()
    assert(number == 45, "Number is not equal to 45")
    val parameterlessNumber: Int = getNumberParameterless
    assert(parameterlessNumber == 45, "parameterlessNumber not equal to 45")
    val stringConcatenation: String = concatenateString("Scala", 3)
    assert(stringConcatenation == "ScalaScalaScala")
    greet("Khaled", 100)
    val factorialResult: Int = getFactorial(4)
    assert(factorialResult == 24)
    val fibanocciResult: Int = getFibanocci(4)
    assert(fibanocciResult == 3)
    val isPrimeNumberResult1: Boolean = isPrime(3)
    assert(isPrimeNumberResult1)
    val isPrimeNumberResult2: Boolean = isPrime(4)
    assert(!isPrimeNumberResult2)
  }
}
