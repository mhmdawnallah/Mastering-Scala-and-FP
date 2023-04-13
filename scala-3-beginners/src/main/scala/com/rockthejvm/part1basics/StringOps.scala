package com.rockthejvm.part1basics

object StringOps {
  def main(args: Array[String]): Unit = {
    val string: String = "Hello, I am learning Scala!"
    val numberAsString: String = "231"

    // Mostly standard in other programming languages
    val secondChar: Char = string.charAt(1)
    val helloWorld: String = string.substring(0,5)
    val words: Array[String] = string.split(" " )
    val startsWithHello: Boolean = string.startsWith("Hello")
    val allDashes: String = string.replace(' ', '-')
    val allUpperCase: String = string.toUpperCase()
    val allLowerCase: String = string.toLowerCase()
    val stringLength: Int = string.length

    // Other functions
    val reversedString: String = string.reverse
    val aBunchOfTenChars: String = string.take(10)

    // Primitive types conversion
    val number: Int = numberAsString.toInt

    // Standard Interpolation
    val name = "Alice"
    val age = 12
    val greeting = "Hello, I'm " + name + " and I am " + age + " years old!"
    val greetingV2 = s"Hello, I'm $name and I am $age years old!"
    val greetingV3 = s"Hello, I'm $name and I am ${age+1-1} years old!"

    // f-interpolation
    val speed = 1.2f
    val myth = f"$name can eat $speed%2.2f burgers per minute."

    // raw-interpolation
    val escapes = raw"This is a \n newline"

    assert(secondChar == 'e')
    assert(helloWorld == "Hello")
    assert(words sameElements(Array("Hello,", "I", "am", "learning", "Scala!")))
    assert(startsWithHello)
    assert(allDashes == "Hello,-I-am-learning-Scala!")
    assert(allUpperCase == "HELLO, I AM LEARNING SCALA!")
    assert(allLowerCase == "hello, i am learning scala!")
    assert(stringLength == 27)
    assert(reversedString == "!alacS gninrael ma I ,olleH")
    assert(aBunchOfTenChars == "Hello, I a")
    assert(number == 231)
    assert(greeting == "Hello, I'm Alice and I am 12 years old!")
    assert(greeting == greetingV2)
    assert(greeting == greetingV3)
    assert(myth == "Alice can eat 1.20 burgers per minute.")
    assert(escapes == raw"This is a \n newline")

  }
}
