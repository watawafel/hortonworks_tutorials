import pyspark
from pyspark import SparkContext


tit = sc.textFile("titanic.csv")

tit.take(5)

tit.first()

tit.take(10)

tit.count()


