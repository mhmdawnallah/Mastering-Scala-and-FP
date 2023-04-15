package com.rockthejvm.part2oop

import com.rockthejvm.part2oop.AnonymousClasses.Person

/**
 * 1) Anonymous Classes can be used in Scala in Abstract Classes, Traits, and Non-Abstract Classes
 */
object AnonymousClasses {

  trait Greeting {
    def greet(name: String): String
  }

  abstract class Animal {
    def eat(): String
  }

  abstract class Person extends Greeting

  def main(args: Array[String]): Unit = {
    val greeting = new Greeting {
      override def greet(name: String): String = s"Hello, $name!"
    }
    val someAnimal = new Animal {
      override def eat(): String = "Some Animal is Eating"
    }
    val someoneGreet = new Person {
      override def greet(name: String): String = s"Hello, $name!"
    }

    val greetingMsg: String = greeting.greet("Mohamed")
    val someAnimalEating: String = someAnimal.eat()
    val ahmedGreeting: String = someoneGreet.greet("Ahmed")
    assert(greetingMsg == "Hello, Mohamed!")
    assert(someAnimalEating == "Some Animal is Eating")
    assert(ahmedGreeting == "Hello, Ahmed!")


  }
}
