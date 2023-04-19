package com.rockthejvm.part3fp
import scala.concurrent.duration.DurationInt

/**
 * 1) Sequential = Well-defined ordering + indexing
 * 2) By default, most expressions are evaluated eagerly in Scala
 * 3) Lazy evaluation is a powerful feature in Scala that delays the evaluation of an expression until its result is needed. This means that the expression is only evaluated once and the result is cached for later use. This can lead to significant performance improvements, especially in situations where evaluating an expression is expensive or the result of the expression is not always needed.
 * 3.1) In Scala, lazy evaluation can be used in several ways. One way is to use the lazy keyword to declare a lazy value or lazy variable
 * 3.2) Another way to use lazy evaluation in Scala is with the view method, which creates a lazy view of a collection. A view is a wrapper around a collection that delays the evaluation of the collection until its values are actually needed
 * 4) The main feature of an Array in Scala is that it is mutable unlike Vectors, List, and Sequence Trait
 */
object LinearCollections {

  def main(args: Array[String]): Unit = {
    testSequences()
    testLists()
    testRanges()
    testArrays()
    testBenchmarkingVectorVsList()
    testSets()
    testEagerEvaluation()
    testLazyEvaluation()

  }

  def testSequences(): Unit = {
    val aSequence = Seq(2, 4, 6, 8, 10)
    val unsortedSequence = Seq(10, 8, 6, 4, 2)
    val thirdElement = aSequence.apply(3)
    val reversedSequence = aSequence.reverse
    val sortedSequence: Seq[Int] = unsortedSequence.sorted
    val concatenatedSequence = aSequence ++ Seq(12, 14, 16)
    val mutableArray = Array(1, 2, 3)
    val anIncrementedSequence = aSequence.map(_ + 1)
    val aFlatMappedSequence = aSequence.flatMap(x => Seq(x, x + 1))
    val aFilteredSequence = aSequence.filter(_ % 2 == 0)
    mutableArray(0) = 2
    mutableArray(1) = 1
    assert(thirdElement == 8)
    assert(reversedSequence == Seq(10, 8, 6, 4, 2))
    assert(concatenatedSequence == Seq(2, 4, 6, 8, 10, 12, 14, 16))
    assert(mutableArray.mkString(", ") == "2, 1, 3")
    assert(sortedSequence == Seq(2, 4, 6, 8, 10))
    assert(anIncrementedSequence == Seq(3, 5, 7, 9, 11))
    assert(aFlatMappedSequence == Seq(2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    assert(aFilteredSequence == aSequence)
  }
  def testLists(): Unit = {
    val list = List(1,2,3)
    val aBiggerList = 0 +: list :+ 4
    val prependingToList = 0 :: list
    val sumList = list.sum
    val foldedSumList = list.fold(0)(_ + _)
    val separatedElements = list.mkString("[", ",", "]")
    val scala5 = List.fill(5)("Scala")
    val lazyRange = (1 to 30).view
    (lazyRange).foreach(_ => println("Scala"))
    assert(list.head == 1)
    assert(list.last == 3)
    assert(list.tail == List(2,3))
    assert(aBiggerList == List(0,1,2,3,4))
    assert(list == List(1,2,3))
    assert(prependingToList == List(0,1,2,3))
    assert(sumList == foldedSumList)
    assert(separatedElements == "[1,2,3]")
    assert(scala5 == List("Scala","Scala","Scala","Scala","Scala"))
  }
  def testRanges(): Unit = {
    val aRange = (1 to 10).view
    aRange.foreach(_ => println("Scala"))
    assert(true)
  }

  def testArrays(): Unit = {
    val anArray = Array(1,1,2,3,4)
    anArray.update(0,0)
    val aConvertedSequence: Seq[Int] = anArray.toIndexedSeq
    assert(anArray sameElements  Array(0,1,2,3,4))
    assert(aConvertedSequence == Seq(0,1,2,3,4))
  }

  def testBenchmarkingVectorVsList(): Unit = {
    val vectorStart = System.nanoTime()
    val vector = (1 to 1000000).toVector
    val vectorEnd = System.nanoTime()
    val vectorTime = (vectorEnd - vectorStart) / 1000000.0
    println(s"Time taken to create Vector: $vectorTime ms")

    val listStart = System.nanoTime()
    val list = (1 to 1000000).toList
    val listEnd = System.nanoTime()
    val listTime = (listEnd - listStart) / 1000000.0
    println(s"Time taken to create List: $listTime ms")

    // Access elements in Vector
    val vectorAccessStart = System.nanoTime()
    vector(500000)
    val vectorAccessEnd = System.nanoTime()
    val vectorAccessTime = (vectorAccessEnd - vectorAccessStart) / 1000000.0
    println(s"Time taken to access element in Vector: $vectorAccessTime ms")

    // Access elements in List
    val listAccessStart = System.nanoTime()
    list(500000)
    val listAccessEnd = System.nanoTime()
    val listAccessTime = (listAccessEnd - listAccessStart) / 1000000.0
    println(s"Time taken to access element in List: $listAccessTime ms")

    // Append element in Vector
    val vectorAppendStart = System.nanoTime()
    val vectorAppended = vector :+ 1000001
    val vectorAppendEnd = System.nanoTime()
    val vectorAppendTime = (vectorAppendEnd - vectorAppendStart) / 1000000.0
    println(s"Time taken to append element to Vector: $vectorAppendTime ms")

    // Append element to List
    val listAppendStart = System.nanoTime()
    val listAppended = list :+ 1000001
    val listAppendEnd = System.nanoTime()
    val listAppendTime = (listAppendEnd - listAppendStart) / 1000000.0
    println(s"Time taken to append element to List: $listAppendTime ms")

    assert(vectorTime < listTime)
    assert(vectorAccessTime < listAccessTime)
    assert(vectorAppendTime < listAppendTime)
  }

  def testSets(): Unit = {
    val aSet = Set(1,2,3,4,5,4)
    val contains3 = aSet.contains(3)
    val contains3_v2 = aSet(3)
    val aBiggerSet = aSet + 7
    val aSmallerSet = aSet - 4
    val anotherSet = Set(6,7,8,9,10)
    val aMuchBiggerSet = anotherSet.union(aSet)
    assert(contains3 == contains3_v2)
  }


  def testEagerEvaluation(): Unit = {
    val start = System.currentTimeMillis()
    val delay = Thread.sleep(1.seconds.toMillis)
    val end = System.currentTimeMillis()
    val timeTaken = end - start
    assert(timeTaken >= 1000, s"Time taken was only $timeTaken milliseconds, expected at least 1000 milliseconds")
  }

  def testLazyEvaluation(): Unit = {
    val start = System.currentTimeMillis()
    lazy val delay = Thread.sleep(3.seconds.toMillis)
    val end = System.currentTimeMillis()
    val timeTaken = end - start
    assert(timeTaken < 1000, s"Time taken was only $timeTaken milliseconds, expected less than 1000 milliseconds")
  }
}
