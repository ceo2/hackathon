//import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.combinator._
import calcCaseClass.Number
import calcCaseClass.Sum
import calcCaseClass.Variable
import calcCaseClass.Expr
import scala.util.parsing.input.CharSequenceReader
import calcCaseClass.Equal

object CalcLangParser extends RegexParsers {
   val CHAR = """[a-zA-Z]"""r
 
   val NUM = """[1-9][0-9]*"""r
   
   def equality: Parser[Expr] = summand ~ "=" ~ summand ^^{ case left ~ "=" ~ right => Equal(left, right)}
   
   def summand: Parser[Expr] =  sum | value | variable 
   
   def value = NUM ^^{ s => Number(s.toDouble)}
   
   def variable = CHAR ^^{s => Variable(s)}
   
   def sum: Parser[Expr] = (value | variable) ~ "+" ~ summand ^^{ case left ~ "+" ~ right => Sum(left, right)}
   
//	def parse(s:String) = {
//	    val tokens = new CharSequenceReader(s)
//	    phrase(tokens)
//	}
}


object Test extends App {
//  println(CalcLangParser.summand(new CharSequenceReader("x")))
//  println(CalcLangParser.summand(new CharSequenceReader("2312")))
  println(CalcLangParser.equality(new CharSequenceReader("2+2+2+x+2+2=23423+433")))
}