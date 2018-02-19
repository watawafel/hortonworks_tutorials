import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

val spark = SparkSession
	.builder
	.appName("StructuredNetworkWordCount")
	.getOrCreate()

import spark.implicits._


