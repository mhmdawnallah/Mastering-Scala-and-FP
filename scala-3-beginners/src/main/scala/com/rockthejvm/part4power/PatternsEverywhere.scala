package com.rockthejvm.part4power

/**
 * 1) Catches are actually MATCHES
 * 2) For comprehensions (generators) based on pattern matching
 */
object PatternsEverywhere {

  def main(args: Array[String]): Unit = {
    testCatchesMatching()
    testForComprehensionsMatching()
    testForComprehensionsDeconstructionMatching()
    testDeconstructATuple()
  }

  def testCatchesMatching(): Unit = {
    val potentialFailure = try {
      throw new RuntimeException()
    } catch {
      case e: RuntimeException => "Runtime Exception"
      case npe: NullPointerException => "NullPointer Exception"
      case _ => "Some other exception"
    }
  }

  def testForComprehensionsMatching(): Unit = {
    val aList = List(1,2,3,4)
    val evenNumbers = for {
      n <- aList if n % 2 == 0
    } yield n * 10
    assert(evenNumbers == List(20, 40))
  }

  def testForComprehensionsDeconstructionMatching(): Unit = {
    val aTuple = List((1,2), (3,4))
    val filterTuples = for {
      (first, second) <- aTuple if first < 3
    } yield second * 100
    assert(filterTuples == List(200))
  }

  def testDeconstructATuple(): Unit = {
    val aTuple = (1,2,3)
    val (a,b,c) = aTuple
    val tuples = List((1,2),(3,4))
    val head :: tail = tuples
    assert(a == 1)
    assert(b == 2)
    assert(c == 3)
    assert(head == (1,2))
    assert(tail == List((3,4)))
  }

}
