package com.rockthejvm.part2oop

/**
 * 1) Case class have special features over the traditional class in Scala:
 * 1.1) Class Args are now fields
 * 1.2) toString, equals, and hash code
 * 1.3) Utility methods e.g: Copy method
 * 1.4) Companion Objects
 * 1.5) Serialization <-> Akka
 * 1.6) Pattern Matching
 * 2) Case Classes sutable for Lightweight data structures
 * 3) Case Classes can't be used for classes with no arguments
 */
object CaseClasses {

  case class Person(name: String, age: Int)

  case object CCWithNoArgs {
    def name: String = "Mohamed Awnallah"
  }

  def main(args: Array[String]): Unit = {
    val person = Person("Jackson", 400)
    val person2 = Person("Jack", 600)
    val person2Younger = person2.copy(age=100)
    println(person2Younger)

  }
}
