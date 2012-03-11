package calcCaseClass

object SummerFromBookCaseClasses extends App {
  //val expr = Equal(Sum(Sum(Number(2), Variable("x"))/*Number(2))*/, Number(3)), Sum(Number(13), Number(13)))
  //val expr = Equal(Sum(Sum(Number(2), Sum(Number(3), Variable("x"))), Number(3)), Sum(Number(13), Variable("y")))
  val expr = Equal(Sum(Prod(Number(2), Sum(Number(3), Variable("x"))), Number(3)), Sum(Number(13), Number(10)))
  println(expr)
  //println(Calculator.eval(expr))
  Calculator.pp(expr)
  println()
  val new_expr = Calculator.solve(expr)
  Calculator.pp(new_expr)
  

}

object Calculator
{
      var count: Int = 0
//    def eval(e: Expr): Int = e match {
//    case Number(n) => n
//    case Sum(l, r) => eval(l) + eval(r)
//    //case Prod(l, r) => eval(l) * eval(r)
//  }
  def solve(e: Expr): Expr = e match {
    case Number(n) => e
    case Variable(name) => e
    
    //easy sum
    case Sum(Number(l), Number(r)) => Number(l+r)
    case Sum(Variable(l), Number(r)) => e
    //Tausche Terme
    case Sum(Number(l), x) => solve(Sum(x,Number(l)))
    //Vereinfachung    
    case Sum(Sum(x, Number(l)),Number(r)) => val res = solve(Sum(Number(l), Number(r))); solve(Sum(x, res))
    //nicht zu vereinfachen    
    case Sum(Prod(Variable(va), Number(l)), Number(r)) => e
    //In die Tiefe gehen
    case Sum(l,r) => val l_new = solve(l); val r_new = solve(r); solve(Sum(l_new, r_new))
    //Einfaches Produkt
    case Prod(Number(l), Number(r)) => Number(l*r)
    case Prod(Variable(l), Number(r)) => e
    //Tausche Terme
    case Prod(Number(l), x) => solve(Prod(x,Number(l)))
    //vereinfache
    case Prod(Prod(x, Number(l)),Number(r)) => val res = solve(Prod(Number(l), Number(r))); solve(Prod(x, res))
    case Prod(Sum(x, Number(l)),Number(r)) => val res = solve(Prod(Number(l), Number(r))); solve(Sum(Prod(x, Number(r)), res))
    case Prod(l,r) => val l_new = solve(l); val r_new = solve(r); solve(Prod(l_new, r_new))
    
    case Equal(Variable(l), Number(r)) => e
    case Equal(Number(l), x) => solve(Equal(x, Number(l)))
    case Equal(Sum(x, Number(l)), Number(r)) => val res = solve(Sum(Number(r), Number(-l))); solve(Equal(x, res)) 
    case Equal(Prod(x, Number(l)), Number(r)) => solve(Equal(x, Number(r/l)))
    case Equal(l, r) => val l_new = solve(l); val r_new = solve(r); count += 1; if(count<10) solve(Equal(l_new, r_new)) else Equal(l_new, r_new)
  }
  
  def pp(e: Expr): Unit = e match {
    case Number(n) => print(n)
    case Variable(name) => print(name)
    case Sum(l, r) => print("("); pp(l); print(" + "); pp(r); print(")")
    case Prod(l, r) => print("("); pp(l); print(" * "); pp(r); print(")")
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

case class Prod(e1: Expr, e2: Expr) extends Expr

case class Equal(e1: Expr, e2: Expr) extends Expr
{

}
