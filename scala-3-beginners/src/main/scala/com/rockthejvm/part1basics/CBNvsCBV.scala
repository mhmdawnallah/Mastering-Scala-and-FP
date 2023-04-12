package com.rockthejvm.part1basics

/**
 * Call By Value (CBV) -> Arguments are evaluated before function invocation
 * Cally By Name (CBN) -> the argument expression is not evaluated before being passed to the function. Instead, the expression is evaluated each time it is used within the function. This can be useful when the expression is expensive to compute, or when the expression has side effects that need to be repeated.
 */
object CBNvsCBV {

  def callFunctionByValue(a: Int): Int = a + 1

  def callFunctionByName(a: => Int): Int = a + 1

  def printTwiceByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def printTwiceByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  def inifinite(): Int = 1 + inifinite()

  def printFirst(x: Int, y: => Int) = println(x)

  def main(args: Array[String]): Unit = {
    val callByValueResult: Int = callFunctionByValue(23 + 67)
    val callByNameResult: Int = callFunctionByName(23 + 67)
    assert(callByValueResult == callByNameResult)
    printTwiceByValue(System.nanoTime())
    println("----------")
    printTwiceByName(System.nanoTime())
    printFirst(42, inifinite())
    // inifinite Evaluated before the function invocation
    // printFirst(inifinite(), 42)
  }
}
