package c.x.codingtest.mid

import scala.collection.mutable

object MissleProtector extends App {

  def solution(targets: Vector[Vector[Int]]): Int = {
//    val counterMap = mutable.HashMap[Int, Int]()
//
//    for(t <- targets) {
//      var target = t(0)
//      while(target < t(1)) {
//        counterMap.put(target, counterMap.get(target).map(_+1).getOrElse(1))
//        target += 1
//      }
//    }
//
//    counterMap.toSeq.sortWith(_._2 > _._2).foreach(println)
    var min = Int.MaxValue
    var max = Int.MinValue
    for(t <- targets) {
      min = if(t(0) < min) t(0) else min
      max = if(t(1) > max) t(1) else max
    }

    println(s"$min --> $max")

    return 0
  }

  val testInput = "[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]"


  val targetInput = Vector(Vector(4,5), Vector(4,8), Vector(10, 14), Vector(11,13), Vector(5,12), Vector(3,7), Vector(1,4))
  solution(targetInput)
}
