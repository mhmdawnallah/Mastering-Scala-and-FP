package com.rockthejvm.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

  }

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(5)
    case EXECUTE extends PermissionsWithBits(6)
    case NONE extends PermissionsWithBits(7)
  }



  def main(args: Array[String]): Unit = {
    val readPermission: Permissions = Permissions.READ
    val writePermission: Permissions = Permissions.WRITE
    val executePermission: Permissions = Permissions.EXECUTE
    val nonePermission: Permissions = Permissions.NONE
    assert(readPermission.ordinal == 0)
    assert(writePermission.ordinal == 1)
    assert(executePermission.ordinal == 2)
    assert(nonePermission.ordinal == 3)
  }
}
