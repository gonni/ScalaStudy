package o.cats

import scala.annotation.tailrec

object OwnerSpace {
  def solution(k: Int, score: Vector[Int]): Vector[Int] = {

//    @tailrec
//    def checkTailrec(k: Int, remaining: Vector[Int], buffered: List[Int] , acc: Vector[Int]): Vector[Int] = {
//      if(remaining.isEmpty) acc
//      else {
//        val target = remaining.head
//        val newBuf = (buffered :+ target).sortWith(_ > _).take(k)
//        checkTailrec(k, remaining.tail, newBuf, acc :+ newBuf.last)
//      }
//    }
//    checkTailrec(k, score, List(), Vector())

    val v = score.scanLeft(Vector[Int]()){case(acc, v) => (acc :+ v).sortWith(_ >_).take(k)}
      .tail
      .map(_.last)

    score.scanLeft(Vector[Int]()){case(acc, v) => (acc :+ v).sortWith(_ >_).take(k)}.tail.foreach(println)

//    v.foreach(println)
//    Vector[Int]()
    v
  }

  def main(args: Array[String]): Unit = {
    println(solution(3, Vector(10, 100, 20, 150, 1, 100, 200)))
    println(solution(4, Vector(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)))

//    Vector(10, 10, 10, 20, 20, 100, 100)
//    Vector(0, 0, 0, 0, 20, 40, 70, 70, 150, 300)

//    println(List().tail.last)
  }
}
