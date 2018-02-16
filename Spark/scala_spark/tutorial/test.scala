+ckage pl.japila.spark

import org.apache.spark.{SparkContext, SparkConf}

object SparkMeApp {
    def main(args: Array[String]) {

          val masterURL = "local[*]"  (1)

              val conf = new SparkConf()  (2)
                    .setAppName("SparkMe Application")
                          .setMaster(masterURL)

                              val sc = new SparkContext(conf) (3)

                                  val fileName = util.Try(args(0)).getOrElse("build.sbt")

                                      val lines = sc.textFile(fileName).cache() (4)

                                          val c = lines.count() (5)
                                              println(s"There are $c lines in $fileName")
                                                }
}
