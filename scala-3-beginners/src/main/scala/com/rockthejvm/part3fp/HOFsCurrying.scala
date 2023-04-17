package com.rockthejvm.part3fp

/**
 * 1) Higher-order functions are functions that either take one or more functions as arguments or return a function as a result. In Scala, functions are first-class citizens, which means they can be treated like any other value. This makes it easy to define and use higher-order functions.
 */
object HOFsCurrying {

  val aHof: (Int, (Int => Int)) => Int = (x, func) => func(x)

  def applyFunction(f: (Int, Int) => Int, x: Int, y: Int): Int = {
    f(x, y)
  }

  def sum(x: Int, y: Int): Int = {
    x + y
  }

  def product(x: Int, y: Int): Int = {
    x * y
  }

  def createFunction(f: (Int, Int) => Int, x: Int): Int => Int = {
    (y: Int) => f(x, y)
  }

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = (x, func) => (y => x + y)

  def nTimes(f: Int => Int, n: Int, x: Int): Int = ???

  def main(args: Array[String]): Unit = {

    val result1 = applyFunction(sum, 2, 3)
    assert(result1 == 5)

    val result2 = applyFunction(product, 2, 3)
    assert(result2 == 6)

    val add5 = createFunction(sum, 5)
    val result3 = add5(3)
    assert(result3 == 8)

    val result4 = add5(7)
    assert(result4 == 12)

    val result: Int = aHof(5, x => x * x)
    assert(result == 25)
  }
}
