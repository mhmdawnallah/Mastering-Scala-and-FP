package com.rockthejvm.part1basics

import scala.annotation.tailrec

/**
 * 1) Default Arguments in Scala
 * 2) Named Arguments in Scala
 */
object DefaultArgs {

  @tailrec
  def sumUntilTailRecursion(number: Int, accumlator: Int = 0): Int = {
    if (number <= 0) accumlator
    else sumUntilTailRecursion(number - 1, accumlator + number)
  }

  def savePicture(dirPath: String, name: String, format: String = "jpg", width: Int = 1920, height: Int = 1089): Unit =
    println("Saving " + name + " in format " + format + " in path " + dirPath)

  def main(args: Array[String]): Unit = {
    val sumUntil100: Int = sumUntilTailRecursion(100)
    assert(sumUntil100 == 5050)
    savePicture("/home/ubuntu/photos","my_image", "png")
    savePicture("/home/ubuntu/photos","my_image", width=800, height = 600)



  }
}
