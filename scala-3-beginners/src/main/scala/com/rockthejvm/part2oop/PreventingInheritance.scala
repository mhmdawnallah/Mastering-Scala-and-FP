package com.rockthejvm.part2oop

/**
 * 1) final keyword infront of method to disable overriding
 * 2) final keyword infront of class to disable inheritance
 * 3) sealing a type hierachy
 * 4) Heavy inheritance is mostly not encouraged in scala
 * 5) no modifer = "not encouraging" inheritance if you wanna explicit that class to be extended you should use open
 * 6) Sealing a type hierarchy in Scala is a technique used to restrict the inheritance hierarchy of a class or trait to a finite set of subclasses. When a class or trait is sealed, it means that it can only be extended by classes or traits defined in the same source file.
 */
object PreventingInheritance {

  class Person(name: String) {
    final def enjoyLife(): Int = 42
  }

  class Adult(name: String) extends Person(name) {
//    override def enjoyLife(): Int = 999
  }

  // sealing a type hierach
  sealed class Guitar(nStrings: Int)
  class ElectricGuitar(nStrings: Int) extends Guitar(nStrings)
  class AcousticGuitar extends Guitar(6)

  open class ExtensibleGuitar(nStrings: Int) // open marked for extension

  def main(args: Array[String]): Unit = {

  }
}
