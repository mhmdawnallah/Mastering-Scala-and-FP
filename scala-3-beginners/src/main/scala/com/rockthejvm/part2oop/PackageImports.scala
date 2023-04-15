package com.rockthejvm.part2oop
import com.rockthejvm.part2oop.Enums.Permissions
import java.util.{List as JList}
import Constants.{PI, EARTH_GRAVITY}
/**
 * 1) Referencing packages using Fully Qualified Name
 * 2) Import using Fully Qualified Name
 * 3) Import as an alias e.g: When we have a package that has a conflict with a standard one
 * 4) You could import all classes/methods inside a package using * but this is not recommended because it makes collision happens
 * 5) We could import multiple symbols
 * 6) Top-level definitions are some kind of anti-patterns to avoid
 * 7) export feature instead of use the on the class/method name you just use the member you wanna access directly
 */
object PackageImports {

  def main(args: Array[String]): Unit = {
    val permissions: Permissions  = Permissions.READ
    val c = PI
    val earth_gravity = EARTH_GRAVITY
    print(c, earth_gravity)
  }
}

object Constants {
  val PI = 3.14
  val EARTH_GRAVITY = 9.8
}