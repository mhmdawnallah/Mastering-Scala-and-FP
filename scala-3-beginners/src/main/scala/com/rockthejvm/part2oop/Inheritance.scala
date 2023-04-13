package com.rockthejvm.part2oop

/**
 * 1) Inheritance in Scala: If you declare the constructor for the parent class you should do as well when iheriting this parent class
 * 2) Polymorphism in Scala can be classified into two types: compile-time polymorphism and runtime polymorphism.
 * 3) Compile-time polymorphism is also known as static polymorphism or method overloading. It is determined at compile-time by the number and types of arguments passed to a method. The method call is bound to a specific method implementation before the program is executed. Method overloading is an example of compile-time polymorphism.
 * 4) Runtime polymorphism is also known as dynamic polymorphism or method overriding. It is determined at runtime by the actual type of the object. The method call is bound to a specific method implementation at runtime. Method overriding is an example of runtime polymorphism.
 * 5) Overloading a function with the parameters & parameter types but only different return type is not considered an overload
 */
object Inheritance {

  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("Eating...")
  }

  class Cat extends Animal {
    def sound(): Unit = println("meow!!")
    def crunch(): Unit = {
      eat()
      sound()
      println("Crunching.....")
    }
  }

  class Person(val name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  class Animal2(val name: String) {
    def speak(): Unit = println("An animal makes a sound")
  }

  class Dog(name: String) extends Animal2(name) {
    override def speak(): Unit = println("Woof!")

    // Popular override method
    override def toString: String = "A Dog"
  }

  //subtype o
  val dog: Animal2 = new Dog("Doggy")

  def main(args: Array[String]): Unit = {
    val cat = new Cat()
    cat.crunch()
    val dog = new Dog("Doggy")
    dog.speak()
    println(dog.toString) // println(dog.toString())
  }

}
