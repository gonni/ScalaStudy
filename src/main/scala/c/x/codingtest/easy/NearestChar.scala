package c.x.codingtest.easy

import scala.collection.mutable


object NearestChar extends App {
  def solution(s: String): Vector[Int] = {
    import scala.collection._
    val dataMap = mutable.Map[Char, Int]()

    s.toCharArray.zipWithIndex.foldLeft(Seq[Int]()){case (seq, (k, v)) =>
//      val (k, v) = e
      val res = dataMap.getOrElse(k, -1)
      val result = if(res == -1) {
        seq :+ res
      } else {
        seq :+ (v - res)
      }
      dataMap.put(k, v)
      result
    }.toVector
  }

//  solution("banana").foreach(println)
  solution("foobar").foreach(println)
}
