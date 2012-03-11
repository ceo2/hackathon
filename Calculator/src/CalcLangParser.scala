//import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.combinator._
import calcCaseClass.Number
import calcCaseClass.Sum
import calcCaseClass.Variable
import calcCaseClass.Expr
import scala.util.parsing.input.CharSequenceReader

object CalcLangParser extends RegexParsers {
   val CHAR = """[a-zA-Z]"""r
 
   val NUM = """[1-9][0-9]*"""r
   
   def eq: Parser[Expr] = expr ~ "=" ~ expr ^^{ case left ~ "=" ~ right => }
   
   def expr: Parser[Expr] =  sum | value | variable 
   
   def value = NUM ^^{ s => Number(s.toDouble)}
   
   def variable = CHAR ^^{s => Variable(s)}
   
   def sum: Parser[Expr] = (value | variable) ~ "+" ~ expr ^^{ case left ~ "+" ~ right => Sum(left, right)}
   
//	def parse(s:String) = {
//	    val tokens = new CharSequenceReader(s)
//	    phrase(tokens)
//	}   
}


object Test extends App {
//  println(CalcLangParser.expr(new CharSequenceReader("x")))
//  println(CalcLangParser.expr(new CharSequenceReader("2312")))
  println(CalcLangParser.expr(new CharSequenceReader("2+2+2+x+2+2")))
}