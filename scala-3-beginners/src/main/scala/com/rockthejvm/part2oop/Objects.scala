package com.rockthejvm.part2oop

/**
 * 1) Object is a single design pattern in one line
 * 2) In Scala, a companion is a design pattern where a class and its companion object are defined in the same file with the same name. The class is called the companion class, and the object is called the companion object.
 * 3) The companion class and companion object have access to each other's private members which makes them useful for creating related functionality that is (tightly coupled).
 * 4) The companion object can be thought of as a singleton instance of the class, and it can be used to define (static methods) and (static fields) that are related to the class.
 * 5) Equality in Scala: a) Equality of Reference (Memory Address Reference) b) Equality of "samenesss"
 */
object Objects {
  object MySingleton {
    val aField = 45
    def aMethod(x: Int) = x + 1
  }

  // methods and fields in classes are used for instance-dependent functionality
  class Person(name: String) {
    def sayHi(): String = s"Hi my name is $name"
  }

  // methods and fields in classes are used for instance-independent functionality - "static"
  // companions = (companion class + companion object) if and only if they are in the same file
  object Person {
    val N_EYES = 2
    def canFly(): Boolean = false
  }


  def main(args: Array[String]): Unit = {
    val firstSingleton = MySingleton
    val secondSingleton = MySingleton
    val personSingleton = Person
    val mohamed = Person("Mohamed")
    val ahmed = Person("Ahmed")
    assert(firstSingleton == secondSingleton)
    assert(firstSingleton.aField == MySingleton.aField)
    assert(firstSingleton.aMethod(3) == MySingleton.aMethod(3))
    assert(mohamed.sayHi() == "Hi my name is Mohamed")
    assert(Person.N_EYES == 2)
    assert(!Person.canFly())
    assert(!(mohamed eq ahmed))
    assert(MySingleton eq MySingleton)
  }
}
