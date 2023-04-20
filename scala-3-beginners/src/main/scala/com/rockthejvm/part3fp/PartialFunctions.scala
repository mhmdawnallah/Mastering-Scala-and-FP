package com.rockthejvm.part3fp

object PartialFunctions {
  def main(args: Array[String]): Unit = {
    assert(!divide.isDefinedAt(0))
    assert(divide.isDefinedAt(7))
    assert(divide(7) == 6)
  }
  val divide: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }
}
