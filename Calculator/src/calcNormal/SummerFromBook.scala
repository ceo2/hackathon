package calcNormal

object SummerFromBook extends App {
  val expr = new Sum(new Sum(new Number(2), new Number(12)),new Prod(new Number(13), new Number(13)))
  println(expr)
  println(expr.eval)
  expr.pp
}

abstract class Expr {
//  def isNumber: Boolean
//  def isSum: Boolean
  
  def eval: Int
  def pp: Unit
}

class Number(n: Int) extends Expr { 
//	def isNumber: Boolean = true
//	def isSum: Boolean = false
	
	def eval: Int = n
	def pp { print(n) }
}

class Sum(e1: Expr, e2: Expr) extends Expr{
//	def isNumber: Boolean = false
//	def isSum: Boolean = true

	def eval: Int = e1.eval + e2.eval
	def pp {e1.pp; print(" + "); e2.pp}
}

class Prod(e1: Expr, e2: Expr) extends Expr{
	
	def eval: Int = e1.eval * e2.eval
	def pp {e1.pp; print(" * "); e2.pp}
}
