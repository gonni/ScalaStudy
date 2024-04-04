package c.x.codingtest.easy

import scala.annotation.tailrec

object RecoverTrainingsuit {

  def solution(n: Int, lost: Vector[Int], reserve: Vector[Int]): Int = {
    val remains = lost.flatMap(a => {
      if(reserve.contains(a)) Vector[Int]()
      else if(reserve.contains(a - 1) || reserve.contains(a + 1)) {

        Vector()
      }
      else Vector[Int](a)
    })

    remains.foreach(println)
    -1
  }

  def main(args: Array[String]): Unit = {
//    println(solution(5, Vector[Int](2,4), Vector[Int](1, 3, 5)))
//    println(solution(5, Vector[Int](2,4), Vector[Int](3)))
//    println(solution(5, Vector[Int](3), Vector[Int](1)))



    val a = Vector[Int](2, 4)
    val b = Vector[Int](1, 3, 4, 5)

    a.diff(b).foreach(println)
    println("------")
    a.intersect(b).foreach(println)
    println("======")
    (a.toSet - 4).foreach(println)
  }
}
