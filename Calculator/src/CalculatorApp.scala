import calcCaseClass.Calculator
import calcCaseClass.Expr
import scala.util.parsing.input.CharSequenceReader

object CalculatorApp extends App {
  val parsedEq = parseEquation("2+3+4+x=12+32")
  Calculator.pp(parsedEq)
  val solvedEquation = Calculator.solve(parsedEq)
  println
  Calculator.pp(solvedEquation)
  
 def parseEquation(s: String): Expr = {
     CalcLangParser.equality(new CharSequenceReader(s)).get
   }

}


