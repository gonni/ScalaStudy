package c.x.mapsort

import scala.::
import scala.collection.Searching.{Found, InsertionPoint}
import scala.collection.immutable

object ListSampleMain extends App {

//  val l1 = immutable.Seq("A", "B", "C")
//  val l2 = "D" +: l1 :+ "E"
//  println(l2)
//
//  val l3 = l2.sorted
//  println(l3)
//
//  val l4 = l2.sortWith((a, b) => a > b)
//  println(l4)

//  val n1 = immutable.Seq(1,2,34,54,3)
//  println("Sum -> " + n1.reduce(_ + _))
//  println("Sum2->" + n1.foldLeft(0)((a1, a2) => {
//    println(s"a1:a2 = $a1:$a2")
//    a1 + a2
//  }))
//
//  println("Sum2->" + n1.foldRight(0)((a1, a2) => {
//    println(s"a1:a2 = $a1:$a2")
//    a1 + a2
//  }))

  // search & insert
  val rank = Int.MaxValue +: Array(100,80,10,7,1,-1) :+ Int.MinValue
  val newScoreStream = Array(30,2,1,-2,4,5)
//  val res = Array[Int]()
//  ss.distinctBy(identity).foreach(println)
//  println(ss.search(1)(Ordering.Int.reverse))

  val rankingBoard = rank.distinctBy(identity)
  val result = newScoreStream.foldLeft(Array.empty[Int]) { case(newRank, v) =>
    rankingBoard.search(v)(Ordering.Int.reverse) match {
      case Found(v) => newRank :+ v
      case InsertionPoint(v) => newRank :+ v
    }
  }

  result.foreach(println)

}
