package c.x.codingtest.easy


import scala.util.control.Breaks.{break, breakable}

object CardMerge extends App {
  def solution(cards1: Vector[String], cards2: Vector[String], goal: Vector[String]): String = {
    import scala.collection._
    val stCard1 = mutable.Stack[String]() ++ cards1
    val stCard2 = mutable.Stack[String]() ++ cards2

    var result = "Yes"
    breakable {
      for (elem <- goal) {
        if (stCard1.nonEmpty && stCard1.top == elem) {
          stCard1.pop()
        } else if (stCard2.nonEmpty && stCard2.top == elem) {
          stCard2.pop()
        } else {
          result = "No"
          break;
        }
      }
    }
    result
  }

  println("result => " + solution(
    Vector("i", "drink", "water"), Vector("want", "to"), Vector("i", "want", "to", "drink", "water")))
  println("result => " + solution(
    Vector("i", "water", "drink"), Vector("want", "to"), Vector("i", "want", "to", "drink", "water")))
}
