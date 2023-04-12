package com.rockthejvm.part1basics

/**
  * Scala is an Expression-based programming language unlike other programming languages
  * e.g: Python, C++, C++ is more instruction-based programming language
  * There is relation between a function programming language and being dependent on expressions
  * We think in Scala in terms of Expressions
*/

object Expressions {

  val sum = 40 + 2
  val mathExpression = 2 + 3 * 4
  val comparison = 2 == 3

  val result = if (comparison) {
    "Both numbers Are Equal"
  } else {
    "Both numbers Aren't Equal"
  }
  val codeBlock = {
    val localValue = 78
    localValue + 54
  }

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  // Unit is equivalent to void in other programming languages
  val yetAnotherValue: Unit = println("Scala")

  def main(args: Array[String]): Unit = {
    println(sum)
    println(mathExpression)
    println(result)
    println(codeBlock)
    assert(someValue)
    assert(someOtherValue == 42)
    assert(yetAnotherValue == ())
    println("Tests succeeded!")
  }
}
