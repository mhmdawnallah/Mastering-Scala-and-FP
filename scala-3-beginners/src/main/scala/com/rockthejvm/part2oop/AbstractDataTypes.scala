package com.rockthejvm.part2oop

/**
 * 1) Abstract Classes can not be instantiated
 * 2) Abstract Classes can contain concrete fields and methods beside abstract fields and methods
 * 3) Traits descripe capabilities like interfaces in Java
 * 4) Traits vs Abstract Classes: Scala allows Single Class Inheritance but we could inherit from multiple traits
 * 5) Traits vs Abstract Classes: Abstract Class means Type (is a relationaship) but Abstract Class is a capabililitiy
 * 6) All classes in Scala inherit automatically from AnyRef
 * 7) All primitive data types in Scala inherit automatically from AnyVal
 * 8) AnyRef and AnyVal inherit both from Any
 */
object AbstractDataTypes {

  abstract class Animal {
    val creatureType: String
    def eat(): Unit
    def preferedMeal: String = "anything"
  }

  class Dog extends Animal {
    override val creatureType: String = "Dog"
    override def eat(): Unit =
      println(s"${this.creatureType} is eating!")

    override def preferedMeal: String = "bones"
  }

  trait Greeting {
    def greet(name: String): String
  }

  class EnglishGreeting extends Greeting {
    override def greet(name: String): String = {
      s"Hello, $name!"
    }
  }

  class SpanishGreeting extends Greeting {
    override def greet(name: String): String = {
      s"Hola, $name!"
    }
  }

  def main(args: Array[String]): Unit = {
    val dog: Animal = Dog()
    dog.eat()
    val englishGreeting = new EnglishGreeting()
    println(englishGreeting.greet("Alice")) // Output: Hello, Alice!

    val spanishGreeting = new SpanishGreeting()
    println(spanishGreeting.greet("Bob")) // Output: Hola, Bob!

    val aNonExistentAnimal: Animal = null
    val anInt: Int = throw new NullPointerException

  }
}
