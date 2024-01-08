package c.x.patterns

object PatternMatchCase extends App {
  trait Expr
  case class Val()

  //----------

  val aTuple = (1,3)
  val matchTuple = aTuple match {
    case (1, somethingElse) => s"A tuple with 1 and $somethingElse"
    case (something, 3) => "contains 3"
  }


  val nestedTuple = (1, (2,3))


}
