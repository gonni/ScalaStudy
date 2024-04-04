package c.x.codingtest.easy

import scala.annotation.tailrec

object NumberDuo {
  def solution(x: String, y: String): String = {
    val (shortv, longv) = if(x.length < y.length) (x, y) else (y, x)

    @tailrec
    def compTailrec(base: String, compString: String, acc: List[Char]): List[Char] = {
      if(base.isEmpty) acc
      else {
        val ch = base.head
        if (compString.contains(ch)) {
          compTailrec(base.tail, compString.replaceFirst(ch.toString, "a"), acc :+ ch)
        } else {
          compTailrec(base.tail, compString, acc)
        }
      }
    }
    compTailrec(shortv, longv, List()) match {
      case a if a.isEmpty => "-1"
      case a => a.sorted(Ordering[Char].reverse).mkString.toInt.toString
    }
  }

  def main(args: Array[String]): Unit = {
//    println("Hello ..")
//
//    println("-->" + solution("100", "203045"))
//    println("-------")
//    println("-->" + solution("12321", "42531"))
//    println("-->" + solution("100", "2345"))

    val a = "12321"
    val b = "42531"



    println(a.intersect(b))
  }
}
