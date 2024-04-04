package c.x.codingtest.easy

import scala.annotation.tailrec

object Cola {
  def solution(base: Int, back: Int, n: Int): Int = {
    @tailrec
    def colaBottleTailrec(input: Int, acc: Int): Int = {
      if(input < base) acc
      else {
        val returnBottle = (input / base) * back
        val remainBottle = input % base
        colaBottleTailrec(remainBottle + returnBottle, acc + returnBottle)
      }
    }
    colaBottleTailrec(n, 0)
  }

  def main(args: Array[String]): Unit = {
    println(solution(2, 1, 20))
  }
}
