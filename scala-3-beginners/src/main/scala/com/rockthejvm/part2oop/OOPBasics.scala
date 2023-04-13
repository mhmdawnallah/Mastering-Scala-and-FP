package com.rockthejvm.part2oop

/**
 * 1) Scala could be used for both object oriented and function programming paradigms
 * 2) Class actual parameter != field to make it equal you add val before the class actual parameter
 * 3) Scala supports method overloading, which allows developers to define multiple methods with the same name but different parameter types or numbers.
 * This can be useful when you need to perform the same operation on different types of data.
 */
object OOPBasics {

  class Person(val name: String, age: Int) {
    // fields
    val nameAllCaps: String = name.toUpperCase()

    // methods with different signatures
    // OVERLOADING
    def greet(name: String): String =
      s"${this.name} says: Hi, $name"

    def greet(): String =
      s"Hi everyone, My name is $name"

    // auxiliary constructors
    def this(name: String) =
      this(name, 0)

    def this() =
      this("Mohamed Awnallah")
  }

  def main(args: Array[String]): Unit = {

    val aPerson: Person = Person("Khaled",215)
    val khaledGreetsMohamed: String = aPerson.greet("Mohamed")
    val khaledGreeting: String = aPerson.greet()
    assert(aPerson.name == "Khaled")
    assert(aPerson.nameAllCaps == "KHALED")
    assert(khaledGreetsMohamed == "Khaled says: Hi, Mohamed")
    assert(khaledGreeting == "Hi everyone, My name is Khaled")


  }
}
