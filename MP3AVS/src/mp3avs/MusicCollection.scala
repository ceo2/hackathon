/**
 *
 */
package mp3avs
import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer

/**
 * @author maierpa
 *
 */
class MusicCollection {
  private val collection = Map[String, ArrayBuffer[String]]()

  def interpreterList() : Iterable[String] = {
    collection.keys
  }
  
  def addAlbum(album: String, interpret: String): Unit = {
    if (collection.contains(interpret)) {
    	collection(interpret) += album
    } else {
    	collection(interpret) = ArrayBuffer(album)
    }
  }  
}


object Test extends App {
	  println("testing class MusicCollection (because I " +
	  			"don't know scala unit tests yet)")
	  			
	  val mc = new MusicCollection()
	  
	  mc.addAlbum("schnokkelude", "The Schnokkers")
	  mc.addAlbum("shpšnkelude", "The Schnokkers")
	  mc.addAlbum("schnukelude", "The Schnokkers")
	  mc.addAlbum("How to longitude", "Spearhead on Mars")
	  mc.addAlbum("Press the button and die", "Spearhead on Mars")
	  
	  for (intp <- mc.interpreterList ) println(intp)
}