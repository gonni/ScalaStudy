package o.cats

object Applicatives {

  import cats.Applicative

  def productWithApplicatives[W[_], A, B](wa: W[A], wb: W[B])(implicit applicative: Applicative[W]): W[(A, B)] = {
    val functionWrappper: W[B => (A, B)] = applicative.map(wa)(a => (b: B) => (a, b))
    applicative.ap(functionWrappper)(wb)
  }

  def main(args: Array[String]): Unit = {

    val x = productWithApplicatives[Option, Int, String](Option(1), None)
    println("Applicative Result =>" + x)

    val y = productWithApplicatives[List, Int, String](List(1,2), List("A", "B"))
    println("Ap Result =>" + y)
    
  }
}
