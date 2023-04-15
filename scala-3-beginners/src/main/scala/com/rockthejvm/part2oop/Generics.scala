package com.rockthejvm.part2oop

import com.rockthejvm.part2oop.Generics.NonEmpty

/**
 * 1) Getter methods with no parameters could act as a properties when overridden by subclasses in Scala
 * 2) Type safety refers to the ability of a programming language to prevent type-related errors at compile-time, rather than at runtime.
 *    This means that the compiler can catch errors such as attempting to assign a value of one data type to a variable of a different data type,
 *    or attempting to call a method on an object that does not support that method.
 * 3) Generics allows the creation of reusable and flexible code components that can work with different data types which in turn increase type safety
 * 4) You can add more than one generic type
 * 5) Compiler can infer generic type from the values being passed
 */
object Generics {

  abstract class List[A]{
    def head: A
    def tail: List[A]
  }

  class Empty[A] extends List[A]{
    override def head: A = throw new NoSuchElementException
    override def tail: List[A] = throw new NoSuchElementException
  }

  class NonEmpty[A](override val head: A, override val tail: List[A] ) extends List[A]

  class MyGenericClass[T](value: T) {
    def getValue(): T = value
  }

  // multiple generic types
  trait MyMap[K, V]

  object List {
    def from2Elements[A](elem1: A, elem2: A): List[A] =
      new NonEmpty[A](elem1, new NonEmpty[A](elem2, new Empty[A]))
  }


  def main(args: Array[String]): Unit = {
    val listNonEmpty1 = NonEmpty[Int](1, new NonEmpty(3,new Empty[Int]))
    val listNonEmpty2 = NonEmpty[Int](2, new NonEmpty(4,new Empty[Int]))
    val resultFromTwoElements: List[Int] = List.from2Elements[Int](1,2)
    val myIntClass = new MyGenericClass[Int](10)
    val myStringClass = new MyGenericClass[String]("Hello, World!")
    assert(listNonEmpty1.head == 1)
    assert(listNonEmpty2.head == 2)
    assert(resultFromTwoElements.head == 1)
    assert(myIntClass.getValue() == 10)
    assert(myStringClass.getValue() == "Hello, World!")

  }
}
