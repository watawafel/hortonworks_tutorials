import java.io.File

val current_dir = System.getProperty("user.dir")

def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
        d.listFiles.filter(_.isFile).toList
    } else {
        List[File]()
    }
}

val files = getListOfFiles(current_dir)

val data = sc.textFile("titanic.csv")

println(s"""
  
          Hello - Looks like you've loaded some data from $current_dir,
          your variables available so far are:
          
          files : files within current directory
          data  : data from specified file(s)
          
          """)



println("DATA HEADER :")
data.first()

println("SAMPLE DATA :")
data.takeSample(false, 10, 0L)


