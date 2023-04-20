package com.rockthejvm.part4power
import scala.concurrent.Future
import concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * 1) Imperative programming in Scala encourages mutable state, which can lead to code that is harder to reason about and debug.
 * 1.1) Mutable state can also lead to concurrency issues, such as race conditions and deadlocks, which can be difficult to diagnose and fix.
 * 1.2) Imperative programming can be less composable than functional programming, making it harder to build modular and reusable code.
 * 1.3) Imperative code is often more verbose and can be harder to read and understand, especially for programmers who are not familiar with the codebase.
 * 1.4) Functional programming provides better support for composition, abstraction, and separation of concerns, making it easier to write more maintainable and scalable code.
 * 1.5) Scala's powerful functional programming features, such as immutable data structures and higher-order functions, make it well-suited for functional programming paradigms.
 * 1.6) Finally, using functional programming in Scala can make code more testable and easier to reason about, as it reduces the number of side effects and dependencies between components.
 * 2) Unit type of variables/function that don't return on meaningful value but they MAY HAVE SIDE EFFECTS
 * 3) Everything in Scala is an Expression
 */
object ImperativeProgramming {
  def main(args: Array[String]): Unit = {
    testMutability()
    testLoop()
    testFutures()
  }

  def testMutability(): Unit = {
    var aVariable: Int = 42
    aVariable = 100
    assert(true)
  }

  def testLoop(): Unit = {
    var i = 0
    while (i < 10) {
      i += 1
    }
    assert(i == 10)
  }

  def increment(n: Int): Int =
    n + 1

  def testFutures(): Unit = {
    val aFuture = Future {
      42
    }
    aFuture.onComplete {
      case Success(meaningOfLife) => println(s"I've found the $meaningOfLife")
      case Failure(exception) => println(s"I've found the $exception")
    }
    assert(true)
  }
}
