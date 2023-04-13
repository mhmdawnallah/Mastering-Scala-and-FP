package com.rockthejvm.part2oop

/**
 * 1) Protected Visibility (within the class and the subclasses that inherit from)
 * 2) Public Visibility (method without access modifier is considered public)
 * 3) Private Visibility (within the class)
 * 4) Package Visibility (withing the package)
 * 5)
 */
object AccessModifiers {

  class Person(val name: String) {
    protected def sayHi(): String = s"Hi, my name is $name"
    private def listenQuran(): String = "I always love listening to Quran!" // only accessible within the class
  }

  class Teacher(override val name: String) extends Person(name){
    def hello(): String = super.sayHi() // no modifier = "public"
  }

  class KidWithParents(override val name: String, age: Int, momName: String, dadName: String) extends Person(name) {
    val mom = new Person(name)
    val dad = new Person(name)

//    def everyoneSayHi(): String =
//      s"Hi, I'm $name, and here are my parents: ${mom.sayHi()} ${dad.sayHi()}" // this considered public I could only call the protected method say on the class instance itself
  }
  def main(args: Array[String]): Unit = {
    val aPerson = new Teacher("Alice")
    print(aPerson.hello())

  }
}
