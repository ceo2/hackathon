package calcCaseClass

object SummerFromBookCaseClasses extends App {
  val expr = Sum(Sum(Number(2), Number(12)), Prod(Number(13), Number(13)))
  println(expr)
  println(eval(expr))
  pp(expr)
  
  
  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(l, r) => eval(l) + eval(r)
    case Prod(l, r) => eval(l) * eval(r)
  }
  
  def pp(e: Expr): Unit = e match {
    case Number(n) => print(n)
    case Sum(l, r) => pp(l); print(" + "); pp(r)
    case Prod(l, r) => pp(l); print(" * "); pp(r)
  }
}

abstract class Expr 

case class Number(n: Int) extends Expr 

case class Sum(e1: Expr, e2: Expr) extends Expr 

case class Prod(e1: Expr, e2: Expr) extends Expr
