import java.io.File
import scala.collection.mutable.ArrayBuffer
    
object MP3AVS {

  def main(args: Array[String]): Unit = 
  {
    println ("Bitte geben Sie das Verzeichnis ein:")
    val directoryPath = readLine()
    
    var musicCollection = scanMusicCollection(directoryPath)
    
    println ("Die Musiksammlung hat folgende Interpreter: ")
    for (interpret <- musicCollection)
    	println(interpret)
  //  giveExistingAlbums()
  //  diffOfAlums()
   // Output()
    
    
    

  }
  
  def scanMusicCollection(path: String) : Array[String] =
  {
	  val source = new File(path)
	  val interpretPathList = source.listFiles().filter(_.isDirectory)
	  val musicCol = ArrayBuffer[String]()
	  for (interpret <- interpretPathList)
	    musicCol += interpret.toString()
//  children.toIterator ++ children.toIterator.flatMap(subdirs _) 

//    var musicCol = Array(path, "zweiter Eintrag")
      musicCol.toArray
  }
 

}
