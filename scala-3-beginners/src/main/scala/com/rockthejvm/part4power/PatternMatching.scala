package com.rockthejvm.part4power

import scala.util.Random
/**
 * 1) Pattern Matching in Scala = Switchs on Steorids
 * 2) Pattern Matching is used also for value decomposition
 * 3) Case classes are applicable for Pattern Matching in Scala
 */
object PatternMatching {

  case class Person(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    testPatternMatching()
    testValuesDecompositionMatching()

  }

  def testPatternMatching(): Unit = {
    val random = new Random()
    val aValue = random.nextInt(100)

    val valueDescription = aValue match {
      case 1 => "The first"
      case 2 => "The second"
      case 3 => "The third"
      case _ => s"Something else: $aValue"
    }
    assert(valueDescription.nonEmpty)
  }

  def testValuesDecompositionMatching(): Unit = {
    val bob = Person("Bob", 13)
    val greeting = bob match {
      case Person(n, a) => s"Hello there, my name is $n and I'm not allowed to say my age"
      case Person(n, a) if a < 16 => s"Hello there, my name is $n and my age is $a "
      case _ => "I don't know who I am"
    }
    assert(greeting == "Hello there, my name is Bob and I'm not allowed to say my age")
  }

}
