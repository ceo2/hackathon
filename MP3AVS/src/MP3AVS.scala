import java.io.File
import scala.collection.mutable.ArrayBuffer
import mp3avs.MusicCollection
    
object MP3AVS {

  def main(args: Array[String]): Unit = 
  {
    println ("Bitte geben Sie das Verzeichnis ein:")
    val directoryPath = readLine()
    
    var musicCollection = scanMusicCollection(directoryPath)
    
    println ("Die Musiksammlung hat folgende Interpreter: ")
    for (interpret <- musicCollection.interpreterList())
    	println(interpret)
  //  giveExistingAlbums()
  //  diffOfAlums()
   // Output()
    
    
    

  }
  
  def scanMusicCollection(path: String) : MusicCollection =
  {
	  val source = new File(path)
	  val interpretPathList = source.listFiles().filter(_.isDirectory)
	  val musicCol = new MusicCollection()
	  
	  for (interpret <- interpretPathList)
	  {
	    val albumPathList = interpret.listFiles().filter(_.isDirectory)
	    for (album <- albumPathList)
	    	musicCol.addAlbum(album.getName().toString(), interpret.getName().toString())
	  }

      musicCol
  }
 

}
