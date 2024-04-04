package c.x.basic

import scala.collection.mutable
import scala.util.Random

object ListMagic extends App {
//  val aList = List(1,2,3)
//  val apppeded = 0 :: aList
//  val aBigList = 0 :: 2 :: 2 :: List(3,4)
//  println(aBigList.mkString("/"))


  val randomSeq100 = Seq.fill(100)(Random.nextInt(100) + 1)
  println(randomSeq100)

  val result = randomSeq100.groupBy(a => a).view.mapValues(_.size).toMap
  result.foreach(println)

  result.toList.sortWith((a, b) => a._2 > b._2).foreach{case(number, cnt) =>
    println(s"$number -> $cnt")
  }

  val ranA = Seq.fill(100)(Random.nextInt(100) + 1)
  val ranB = Seq.fill(100)(Random.nextInt(100) + 1)

  def removeSameValues(a: Seq[Int], b:Seq[Int]) = {
    val b2Set = b.toSet

    val filteredA = a.filter(b2Set.contains)
    val filteredB = b.filter(a.contains)

    (filteredA, filteredB)
  }

  println("-------------------------")
  val (fRanA, fRanB) = removeSameValues(ranA, ranB)
  println(s"${fRanA.length} vs ${fRanB.length}")

  // -----
  val numCountMap = randomSeq100.foldLeft(Map.empty[Int, Int]) {
    (acc, number) => acc + (number -> (acc.getOrElse(number, 0) + 1))
  }

  numCountMap.toList.sortWith((a,b) => a._2 > b._2).foreach(println)

}
