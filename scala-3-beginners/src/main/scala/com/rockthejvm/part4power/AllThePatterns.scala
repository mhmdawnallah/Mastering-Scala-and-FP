package com.rockthejvm.part4power

/**
 * 1) Pattern Matching can be used on Nested Data Structures
 * 2) Pattern Matching can be used for type specifiers
 * 3) Pattern Matching run at the run time
 * 4) Reflection in the Java Virtual Machine (JVM) is a mechanism that allows a program to inspect and modify the behavior of objects at runtime. It provides a way to access and manipulate classes, methods, and fields of an object, even if they are private or hidden from the calling code.
 * 5) Generic types are erased at runtime: List[String] -> List
 */
object AllThePatterns {
  def main(args: Array[String]): Unit = {
    testMatchingTuples()
    testMatchingLists()
    testTrickyMatching()
  }

  def testMatchingTuples(): Unit = {
    val aTuple = (1,4)
    val matchedTuple = aTuple match {
      case (1, otherValue) => s"A tuple with 1 and $otherValue"
      case (something, 2) => s"A tuple with $something and 2"
    }
    assert(matchedTuple == "A tuple with 1 and 4")
  }

  def testMatchingLists(): Unit = {
    val aStandardList = List(1,2,3,42,5)
    val aMatchingStandardList = aStandardList match {
      case List(1, _, _, _) => "List with 4 elements, first is 1"
      case List(1, _*) => "List starting with 1"
      case List(1, 2, 42, _) :+ 5 => "List ending in 5"
      case head :: tail => s"List constructed with $head and $tail"
    }
    println(aMatchingStandardList)
  }

  def testTrickyMatching(): Unit = {
    val numbers: List[Int] = List(1,2,3,4)
    val numbersMatch = numbers match {
      case listOfStrings: List[String] => "A list of strings"
      case listOfInts: List[Int] => "A list of Ints"
    }
    assert(numbersMatch == "A list of strings")
  }

}
