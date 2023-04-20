package com.rockthejvm.part3fp
import java.util.Random
/**
 * 1) Defensive style refers to writing code that handles potential errors and edge cases proactively. When it comes to checking for null pointers, defensive style programming involves verifying whether a variable is null before attempting to access its properties or methods.
 * 2) A non-defensive style approach to checking null pointers involves assuming that a variable is not null and accessing its properties or methods directly. This can lead to runtime errors if the variable is actually null that's why Option comes to play
 * 3) Subtypes of option:
 * 3.1) Some: This subtype of Option represents a value that is present. It is defined as Some[A], where A is the type of the value that is present. For example, Some(10) represents an Option[Int] with a value of 10.
 * 3.2) None: This subtype of Option represents the absence of a value. It is defined as None, and it does not contain any value. For example, None represents an Option[Nothing].
 */
object Options {

  class Connection {
    def connect(): String = "Connected successfully!"
  }

  object Connection {
    val random = new Random()

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }
  def main(args: Array[String]): Unit = {
    testNones()
    testOptions()
    testOptionsExercise()
  }

  def testNones(): Unit = {
    val stringLength = {
      val potentialString = unsafeMethod()
      if (potentialString == null) -1
      else potentialString.length
    }
    assert(stringLength == -1)
  }

  def testOptions(): Unit = {
    val anOption: Option[Int] = Option(42)
    val anEmptyOption: Option[Int] = Option.empty
    val alternativeValue: Int = anEmptyOption.getOrElse(45)
    val stringLengthOption = Option(unsafeMethod()).map(_.length)
    assert(anOption.contains(42))
    assert(anEmptyOption.isEmpty)
    assert(stringLengthOption.isEmpty)
    assert(alternativeValue == 45)
  }

  def testOptionsExercise(): Unit = {
    val configs: Map[String, String] = Map(
      "host" -> "176.45.32.1",
      "port" -> "8081"
    )
    val host: Option[String] = configs.get("host")
    val port: Option[String] = configs.get("port")
    val connection = host.flatMap(h => port.flatMap(p => Connection(h,p)))
    assert(host.contains("176.45.32.1"))
    assert(port.contains("8081"))
  }



  def unsafeMethod(): String = null
  def fallbackMethod(): String = "Fallback method"
}
