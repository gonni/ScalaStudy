package c.x.programers

import scala.annotation.tailrec

object CookHamberger {

  def solution(ig: Vector[Int]): Int = {
    val fixedOrder = "1231"

    @tailrec
    def checkTailrec(target: String, startIdx: Int, acc: Int): Int = {
      val fi = target.indexOf(fixedOrder, startIdx)
      if(fi == -1 || target.length < 4) acc
      else {
        val si = if(fi-4 < 0 ) 0 else fi - 4
        checkTailrec(target.substring(0, fi).concat(target.substring(fi + 4)), si, acc + 1)
      }
    }
    checkTailrec(ig.mkString, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Vector[Int](2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(solution(Vector[Int](2, 1, 2, 3, 1)))


    val x = Vector[Int](2, 1, 1, 2, 3, 1, 2, 3, 1)
    println(x.indexOfSlice(Vector(1,2,3,1), 0))
//    x.in
    //    val s = "1"
//    println(s.substring(0,0))

    val a = "abc123def123gh"
    println(a.replaceFirst("123", ""))


  }
}
