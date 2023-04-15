package com.rockthejvm.part2oop

import com.rockthejvm.part2oop.Exceptions.MyException

/**
 * 1) Errors and Exceptions in Scala extend all from Throwable Class
 * 2) Errors are the errors withing the jvm e.g: Stackoverflow error, Out-of-memory error
 * 3) Exceptions are things wrong with your program e.g: Null pointer exception, Nosuchelement exception
 * 4) Most specific exceptions first in try and catch block
 * 5) You could create customized exceptions by extend from the exception class
 * 6) You could use finally section here for closing the resources opened in the try section
 */
object Exceptions {

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw NullPointerException("No int for you!")
    else 42


  class MyException extends RuntimeException {
    override def getMessage: String = "MY Exception"
  }


  def main(args: Array[String]): Unit = {
    val potentialFailure = try {
      getInt(true)
    } catch {
      case e: NullPointerException => 41
      case e: RuntimeException => 54
    } finally {
      // called no matter what
    }
//    val myException = new MyException
//    val throwingException = throw myException
  }
}
