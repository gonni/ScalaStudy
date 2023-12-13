package c.x.codingtest.hard

import scala.Console.in

object ExprMain extends App {
  val expr = "41 + 3 x 2 + 1"

  val tokens = expr.replaceAll(" ", "").toCharArray//.map(ch => ch.toString
  for(token <- tokens) {
//    if(token.isDigit) println(token)
//    if(token)
  }

}
