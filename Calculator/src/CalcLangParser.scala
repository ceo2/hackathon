//import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.combinator._

object CalcLangParser extends RegexParsers {
   val CHAR = """[a-zA-Z]"""r
 
   val NUM = """[1-9][0-9]*"""r
   
//   def value = NUM ^^{ s => EConst(s.toDouble)}
 
}