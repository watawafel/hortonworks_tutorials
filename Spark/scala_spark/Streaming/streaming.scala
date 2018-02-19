import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession


// Initiates SparkSession
val spark = SparkSession
	.builder
	.appName("StructuredNetworkWordCount")
	.getOrCreate()

import spark.implicits._


// Creates DataFrame form stream input of localhost:9999
val lines = spark.readStream
	.format("socket")
	.option("host", "localhost")
	.option("port", 9999)
	.load()

// Splits Lines
val words = lines.as[String].flatMap(_.split(" "))

// Generate running word count
val wordCounts = words.groupBy("value").count()


// Engage the stream
val query = wordCounts.writeStream
	.outputMode("complete")
	.format("console")
	.start()


query.awaitTermination()
