package com.rockthejvm.part4power

object BracelessSyntax {
  def main(args: Array[String]): Unit = {
    val anIfExpression = if (2 > 3) "bigger" else "smaller"
    val anIfExpression_v2 =
      if (2 > 3) "bigger"
      else "smaller"

  }
}
