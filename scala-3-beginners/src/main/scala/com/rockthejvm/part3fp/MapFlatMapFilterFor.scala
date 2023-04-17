package com.rockthejvm.part3fp

/**
 * 1) In functional programming, "flattening" a list means converting a list of lists into a single list by concatenating all the sub-lists.
 * 2) map is an operation that applies a function to each element of a collection and returns a new collection with the results. The signature of map is:
 * 3) reduce is an operation that combines the elements of a collection using a binary operation and returns a single result. The signature of reduce is:
 * 4) Map and Reduce is popular in MapReduce Programming Model where they are equally distributed across nodes
 * 5) Data locality is a key concept in the Hadoop Distributed File System (HDFS) and Hadoop MapReduce. It refers to the idea of processing data on the same node where the data is stored, rather than moving the data to a different node for processing.
 * 6) For comprehension is a syntactic sugar for flatmaps
 * 7) In particular, when you use a for comprehension with a single generator,
 *    it is equivalent to using a map operation on the collection. When you use a for comprehension with multiple generators, it is equivalent to using nested flatMap operations.
 *    And when you use a for comprehension with a if clause, it is equivalent to using a filter operation.
 */
case class Address(street: String)
case class Person(name: String, age: Int, addresses: List[Address])
case class Company(name: String, people: List[Person])
case class Country(name: String, companies: List[Company])

object MapFlatMapFilterFor {
  def main(args: Array[String]): Unit = {
    val addresses1 = List(Address("123 Main St."), Address("456 Broadway"))
    val addresses2 = List(Address("789 Elm St."))
    val addresses3 = List(Address("555 Oak St."), Address("777 Maple Ave."))

    val person1 = Person("John Doe", 25, addresses1)
    val person2 = Person("Jane Smith", 30, addresses2)
    val person3 = Person("Bob Johnson", 40, addresses3)

    val person4 = Person("Mohamed Awnallah", 100, addresses1)
    val person5 = Person("Ahmed Khaled", 30, addresses2)
    val person6 = Person("Mostafa Ahmed", 40, addresses3)

    val company1 = Company("Acme Inc.", List(person1, person2))
    val company2 = Company("Widgets LLC", List(person3))

    val company3 = Company("Apple Inc.", List(person4, person5))
    val company4 = Company("Google LLC", List(person6))

    val country1 = Country("USA", List(company1, company2))
    val country2 = Country("Egypt", List(company3, company4))

    val countries = List(country1,country2)
    val addresses: List[String] = countries.flatMap((c: Country) => c.companies)
                                  .flatMap((cmp: Company) => cmp.people)
                                  .flatMap((person: Person) => person.addresses)
                                  .map((s: Address) => s.street)
    val expectedAddresses: List[String] = List("123 Main St.", "456 Broadway", "789 Elm St.", "555 Oak St.", "777 Maple Ave.", "123 Main St.", "456 Broadway", "789 Elm St.", "555 Oak St.", "777 Maple Ave.")
    val egyptianPersonNames: List[String] = countries
                                            .filter((c: Country) => c.name.startsWith("E"))
                                            .flatMap((c: Country) => c.companies)
                                            .flatMap((cmp: Company) => cmp.people)
                                            .map((p: Person) => p.name)
    val people = List(
      Person("John", 12, List(Address("919 St."), Address("215 St."))),
      Person("Jack", 444, List(Address("999 St.")))
    )
    val streets: List[Address] = people.flatMap(p => p.addresses)
    val listOfLists = List(List(1, 2), List(3, 4), List(5, 6))
    val flattenedList = listOfLists.flatten

    val streetAddresses: List[String] = for {
      c <- countries
      co <- c.companies
      p <- co.people
      a <- p.addresses
    } yield (a.street)
    assert(addresses == streetAddresses)

    val egyptianPersonNamesComprehension: List[String] = for {
      c <- countries if c.name.startsWith("E")
      co <- c.companies
      p <- co.people
    } yield (p.name)
    assert(egyptianPersonNamesComprehension == egyptianPersonNames)
    assert(addresses == expectedAddresses)
    assert(egyptianPersonNames == List("Mohamed Awnallah", "Ahmed Khaled", "Mostafa Ahmed"))
    assert(streets == List(Address("919 St."), Address("215 St."), Address("999 St.")))
    assert(flattenedList == List(1,2,3,4,5,6))

  }

}
