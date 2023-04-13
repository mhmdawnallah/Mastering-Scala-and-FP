package com.rockthejvm.part2oop

/**
In data engineering, it's common to work with different data sources and sinks (e.g. databases, file systems, message queues, etc.), which often have different APIs or protocols for reading and writing data. This is where the adapter design pattern can be useful.

For example, if you have a data pipeline that reads data from a Kafka message queue and writes it to a database, you may need to use adapters to translate between the Kafka and database APIs. The Kafka consumer and producer APIs may be different from the database's JDBC or ORM APIs, so you can use adapters to provide a consistent interface for your data pipeline.

Similarly, you may need to use adapters to work with different file formats, such as CSV, JSON, or Avro. Each file format has its own API for reading and writing data, so you can use adapters to abstract away these differences and provide a unified interface for your data processing pipeline.

Overall, the adapter design pattern is useful in data engineering because it allows you to decouple your code from specific data sources or sinks, and provides a way to handle different APIs and protocols in a consistent and modular way.
*/
object AdapterDesignPattern {
  // Define a trait for a generic data source
  trait DataSource {
    def read(): Seq[String]
  }

  // Define a trait for a generic data sink
  trait DataSink {
    def write(data: Seq[String]): Unit
  }

  // Define a class for reading CSV data
  class CsvDataSource(filePath: String) extends DataSource {
    def read(): Seq[String] = {
      // Read data from CSV file
      // ...
      Seq("1,John,Doe", "2,Jane,Smith", "3,Bob,Johnson")
    }
  }

  // Define a class for reading JSON data
  class JsonDataSource(filePath: String) extends DataSource {
    def read(): Seq[String] = {
      // Read data from JSON file
      // ...
      Seq("""{"id": 1, "name": "John", "surname": "Doe"}""",
        """{"id": 2, "name": "Jane", "surname": "Smith"}""",
        """{"id": 3, "name": "Bob", "surname": "Johnson"}""")
    }
  }

  // Define a class for writing data to a CSV file
  class CsvDataSink(filePath: String) extends DataSink{
    def write(data: Seq[String]): Unit = {
      // Write data to CSV file
      // ...
      println("Data written to CSV file:")
      data.foreach(println)
    }
  }

  // Define a class for writing data to a JSON file
  class JsonDataSink(filePath: String) extends DataSink{
    def write(data: Seq[String]): Unit = {
      // Write data to JSON file
      // ...
      println("Data written to JSON file:")
      data.foreach(println)
    }
  }

  // Define an adapter class for converting CSV data to JSON data
  class CsvToJsonAdapter(csvDataSource: CsvDataSource) extends DataSource {
    def read(): Seq[String] = {
      // Read data from CSV data source and convert to JSON format
      val csvData = csvDataSource.read()
      csvData.map { row =>
        val Array(id, name, surname) = row.split(",")
        s"""{"id": $id, "name": "$name", "surname": "$surname"}"""
      }
    }
  }

  // Define an adapter class for converting JSON data to CSV data
  class JsonToCsvAdapter(jsonDataSource: JsonDataSource) extends DataSource {
    def read(): Seq[String] = {
      // Read data from JSON data source and convert to CSV format
      val jsonData = jsonDataSource.read()
      jsonData.map { row =>
        val fields = Seq("id", "name", "surname").map(field => (row \ field).as[String])
        fields.mkString(",")
      }
    }
  }



  def main(args: Array[String]): Unit = {
    // Create instances of the data sources, sinks, and adapters
    val csvDataSource = new CsvDataSource("data.csv")
    val jsonDataSource = new JsonDataSource("data.json")
    val csvDataSink = new CsvDataSink("output.csv")
    val jsonDataSink = new JsonDataSink("output.json")
    val csvToJsonAdapter = new CsvToJsonAdapter(csvDataSource)
    val jsonToCsvAdapter = new JsonToCsvAdapter(jsonDataSource)

    // Use the data sources, sinks, and adapters to read and write data
    val data1 = csvDataSource.read()
    val data2 = jsonDataSource.read()
    val data3 = csvToJsonAdapter.read()
    val data4 = jsonToCsvAdapter.read()
    csvDataSink.write(data1)
    jsonDataSink.write(data2)
    jsonDataSink.write(data3)
    csvDataSink.write(data4)

  }
}
