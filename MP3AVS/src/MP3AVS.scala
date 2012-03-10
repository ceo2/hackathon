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
    var musicCol = Array(path, "zweiter Eintrag")
    musicCol
  }
 

}
