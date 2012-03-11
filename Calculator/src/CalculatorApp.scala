object CalculatorApp extends App {
	new Calculator("12+13*24")
}

class Calculator(expr: String) {
  println("processing " + expr)
}