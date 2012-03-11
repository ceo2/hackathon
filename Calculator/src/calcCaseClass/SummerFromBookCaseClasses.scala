package calcCaseClass

object SummerFromBookCaseClasses extends App {
  //val expr = Equal(Sum(Sum(Number(2), Variable("x"))/*Number(2))*/, Number(3)), Sum(Number(13), Number(13)))
  val expr = Equal(Sum(Sum(Number(2), Sum(Number(3), Variable("x"))), Number(3)), Sum(Number(13), Number(13)))
  println(expr)
  //println(Calculator.eval(expr))
  Calculator.pp(expr)
  println()
  val new_expr = Calculator.solve(expr)
  Calculator.pp(new_expr)
  

}

object Calculator
{
//    def eval(e: Expr): Int = e match {
//    case Number(n) => n
//    case Sum(l, r) => eval(l) + eval(r)
//    //case Prod(l, r) => eval(l) * eval(r)
//  }
  def solve(e: Expr): Expr = e match {
    case Number(n) => e
    case Variable(name) => e
    //case Sum(Sum(l,r))
    case Sum(Number(l), Number(r)) => Number(l+r)
    case Sum(Number(l), Sum(Variable(va), Number(r))) => solve(Sum(Variable(va), Sum(Number(l), Number(r))))
    case Sum(Sum(Variable(va), Number(l)),Number(r)) => solve(Sum(Variable(va), Sum(Number(l), Number(r))))
    case Sum(Number(l), Variable(r)) => solve(Sum(Variable(r), Number(l)))
    case Sum(Variable(l), Number(r)) => e
    case Sum(l,r) => val l_new = solve(l); val r_new = solve(r); solve(Sum(l_new, r_new))
    case Equal(Variable(l), Number(r)) => e
    case Equal(Number(l), Sum(Variable(va), Number(r))) => solve(Equal(Sum(Variable(va), Number(r)), Number(l)))
    case Equal(Sum(Variable(va), Number(l)), Number(r)) => solve(Equal(Variable(va), Sum(Number(r), Number(l)))) 
    case Equal(l, r) => val l_new = solve(l); val r_new = solve(r); solve(Equal(l_new, r_new))
  }
  
  def pp(e: Expr): Unit = e match {
    case Number(n) => print(n)
    case Variable(name) => print(name)
    case Sum(l, r) => print("("); pp(l); print(" + "); pp(r); print(")")
    case Equal(l, r) => pp(l); print(" = "); pp(r)
    
    //case Prod(l, r) => pp(l); print(" * "); pp(r)
  }
}

abstract class Expr 
{
  
}

case class Number(n: Double) extends Expr

case class Variable(name: String) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Equal(e1: Expr, e2: Expr) extends Expr

//case class Prod(e1: Expr, e2: Expr) extends Expr
