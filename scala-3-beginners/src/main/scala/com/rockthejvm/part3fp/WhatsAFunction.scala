package com.rockthejvm.part3fp

/**
 * 1) Functions are first-class citizens
 * 2) All functions are instances of FunctionX with apply methods because functions are implemented as objects that extend the FunctionX trait, where X is the number of arguments the function takes
 * 3) Currying is a technique in functional programming where a function that takes multiple arguments is transformed into a sequence of functions that each take a single argument. In Scala, currying is achieved using the curried method that's available on any function with multiple arguments.
 * 4) Function Values != Methods
 */
object WhatsAFunction {

  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  def add(x: Int, y: Int): Int = x + y

  def main(args: Array[String]): Unit = {
    val doubler = new MyFunction[Int, Int] {
      override def apply(arg: Int): Int = arg * 2
    }
    val numberDoubled = doubler(2)
    assert(numberDoubled == 4)

    val doublerStandard = new Function[Int, Int] {
      override def apply(v1: Int): Int = v1 * 2
    }
    val numberDoubled2 = doublerStandard(2)
    assert(numberDoubled2 == numberDoubled)

    val adder = new Function2[Int, Int, Int] {
      override def apply(v1: Int, v2: Int): Int = v1 + v2
    }

    val additionResult = adder(1, 2)
    assert(additionResult == 3)

    val concatenator: (String, String) => String = (a: String, b: String) => a + b
    val concatenationResult = concatenator("Mohamed", " Awnallah")
    assert(concatenationResult == "Mohamed Awnallah")

    val curriedAdd = add.curried
    val add2 = curriedAdd(2)
    val add5 = curriedAdd(5)
    assert(add2(3) == 5)
    assert(add5(3) == 8)

  }
}
