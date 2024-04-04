package c.x.codingtest.easy

import scala.annotation.tailrec

object GiveupMath {

  def solution(answers: Vector[Int]): Vector[Int] = {
    val student1 = Seq(1, 2, 3, 4, 5)
    val student2 = Seq(2, 1, 2, 3, 2, 4, 2, 5)
    val student3 = Seq(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    var acc = Map(1->0, 2->0, 3->0)

    @tailrec
    def processing(idx: Int): Map[Int, Int] = {
      if(idx == answers.length) acc
      else {
        if (student1(idx % student1.length) == answers(idx))
          acc = acc + (1 -> (1 + acc(1)))
        if (student2(idx % student2.length) == answers(idx))
          acc = acc + (2 -> (1 + acc(2)))
        if (student3(idx % student3.length) == answers(idx))
          acc = acc + (3 -> (1 + acc(3)))
        processing(idx + 1)
      }
    }

    processing(0)

    val maxVal = acc.maxBy(_._2)._2
    acc.toSeq.filter(a => a._2 == maxVal).sortBy(_._1).map(_._1).toVector
  }

  def main(args: Array[String]): Unit = {
    solution(Vector(1,2,3,4,5,1,2,3,4,5,1,2,3,4,5)).foreach(println)
    println("-----------")
    solution(Vector(1,3,2,4,2)).foreach(println)
  }
}
