package com.rockthejvm.part3fp

/**
 * 1) Tuples are finite ordered lists
 */
object TuplesMaps {
  def main(args: Array[String]): Unit = {
    testTuples()
    testMaps()
  }

  def testTuples(): Unit = {
    val aTuple = (2, "rock the jvm")
    val aTuple_v2 = 2 -> "rock the jvm"
    assert(aTuple == aTuple_v2)
    assert(aTuple_v2(0) == 2)
    assert(aTuple_v2(1) == "rock the jvm")
  }

  def testMaps(): Unit = {
    val phonebook: Map[String, Int] = Map(
      "Jim" -> 555,
      "Daniel" -> 789,
      "Jane" -> 123
    ).withDefaultValue(-1)
    val phonebookHasMohamed = phonebook.contains("Mohamed")
    val phonebookHasDaniel = phonebook.contains("Daniel")
    val maryPhoneNumber = phonebook("Mary")
    assert(!phonebookHasMohamed)
    assert(phonebookHasDaniel)
    assert(maryPhoneNumber == -1)

    // Add a pair
    val aNewPair = "Mary" -> 314
    val newPhonebook = phonebook + aNewPair
    assert(newPhonebook.contains("Mary"))

    // Remove a key
    val phonebookWithoutDaniel = phonebook - "Daniel"
    assert(!phonebookWithoutDaniel.contains("Daniel"))

    val linearPhoneBook = List(
      "Jim" -> 555,
      "Daniel" -> 789,
      "Jane" -> 123
    )
    val phonebook_v2 = linearPhoneBook.toMap
    assert(phonebook_v2 == phonebook)

    val aProcessedPhonebook = phonebook.map(pair => (pair._1.toUpperCase(), pair._2))
    assert(aProcessedPhonebook == Map("JIM" -> 555, "DANIEL" -> 789, "JANE" -> 123))

    val noJs: Map[String, Int] = phonebook.view.filterKeys(!_.startsWith("J")).toMap
    assert(noJs == Map("Daniel" -> 789))

    val prefixNumbers = phonebook.view.mapValues(number => s"0255-$number").toMap
    assert(prefixNumbers == Map("Jim" -> "0255-555", "Daniel" -> "0255-789", "Jane" -> "0255-123"))

    val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
    val nameGroupings: Map[Char, List[String]] = names.groupBy(name => name.charAt(0))
    val expectedNameGroupings = Map('J' -> List("James", "Jim"), 'A' -> List("Angela"), 'M' -> List("Mary"), 'B' -> List("Bob"), 'D' -> List("Daniel"))
    assert(nameGroupings == expectedNameGroupings)

  }
}
