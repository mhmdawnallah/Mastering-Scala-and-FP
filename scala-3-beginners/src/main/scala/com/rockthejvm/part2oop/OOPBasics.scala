package com.rockthejvm.part2oop

/**
 * 1) Scala could be used for both object oriented and function programming paradigms
 * 2) Class actual parameter != field to make it equal you add val before the class actual parameter
 * 3) Scala supports method overloading, which allows developers to define multiple methods with the same name but different parameter types or numbers.
 * This can be useful when you need to perform the same operation on different types of data.
 * 4) Immutable data structures are data structures whose state cannot be modified after they are created. Instead of modifying the existing data, immutable data structures create new instances of the data whenever a change is made. There are several reasons why we use immutable data structures:
      a) Thread safety: Immutable data structures are inherently thread-safe since multiple threads can read the same data without the risk of one thread modifying the data while another thread is reading it.
      b) Predictability:Immutable data structures have predictable behavior, which can be important in a distributed environment where nodes may be running different code versions or may be located in different parts of the world with varying network latencies.
      c) Performance: Immutable data structures can often be more performant than their mutable counterparts. Because they cannot be modified, they can be cached and reused more easily.
      d) Ease of testing: Immutable data structures are easier to test since their state cannot be modified. This makes it easier to write unit tests that can reliably predict the behavior of the system.
      e) Functional programming: Immutable data structures are a key component of functional programming. In functional programming, functions do not have side effects and always return the same result for the same inputs. Immutable data structures support this approach by providing data that cannot be modified.
 * 5) Tradeoffs of using Immutable Data Structures:
 *    a) Memory overhead: Because immutable data structures create new instances whenever a change is made, they can use more memory than mutable data structures. This can be a concern in memory-constrained environments.
      b) Difficulty in updating: While immutable data structures can be more performant when it comes to reading data, updating data can be more difficult since a new instance needs to be created. This can make certain operations less efficient than their mutable counterparts.
      c) Limited support in certain languages: Some programming languages do not have built-in support for immutable data structures, which can make it more difficult to use them effectively.
      d) Time complexity: Some operations on immutable data structures can have higher time complexity than their mutable counterparts, which can impact the performance of applications that rely heavily on these operations.
      e) Learning curve: Using immutable data structures effectively can require a different way of thinking about data and programming. Developers who are used to working with mutable data structures may need to invest time and effort into learning how to use immutable data structures effectively.
 */
object OOPBasics {

  class Person(val name: String, age: Int) {
    // fields
    val nameAllCaps: String = name.toUpperCase()

    def greet(name: String): String =
      s"${this.name} says: Hi, $name"

    def greet(): String =
      s"Hi everyone, My name is $name"

    def this(name: String) =
      this(name, 0)

    def this() =
      this("Mohamed Awnallah")
  }

  class ImmutableCounter(val counter: Int = 1) {
    def increment(): ImmutableCounter =
      new ImmutableCounter(this.counter + 1)

    def decrement(): ImmutableCounter =
      if (this.counter == 0) this
      else new ImmutableCounter(this.counter - 1)

    def print(): Unit =
      println(s"Current count: ${this.counter}")

  }
  def main(args: Array[String]): Unit = {

    val aPerson: Person = Person("Khaled",215)
    val khaledGreetsMohamed: String = aPerson.greet("Mohamed")
    val khaledGreeting: String = aPerson.greet()
    val immutableCounter = ImmutableCounter(3)
    val incrementedCounter: ImmutableCounter = immutableCounter.increment()
    val decrementedCounter: ImmutableCounter = immutableCounter.decrement()
    assert(aPerson.name == "Khaled")
    assert(aPerson.nameAllCaps == "KHALED")
    assert(khaledGreetsMohamed == "Khaled says: Hi, Mohamed")
    assert(khaledGreeting == "Hi everyone, My name is Khaled")
    assert(incrementedCounter.counter == 4)
    assert(decrementedCounter.counter == 2)

  }
}


