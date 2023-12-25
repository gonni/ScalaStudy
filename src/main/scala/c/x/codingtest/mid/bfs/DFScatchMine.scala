package c.x.codingtest.mid.bfs

import scala.collection.mutable

object DFScatchMine extends App {

  val scoreMap : Map[(String,String), Int] = Map(
    ("diamond", "diamond") -> 1,
  ("diamond", "iron") -> 1,
  ("diamond", "stone") -> 1,
  ("iron", "diamond") -> 5,
  ("iron", "iron") -> 1,
  ("iron", "stone") -> 1,
  ("stone", "diamond") -> 25,
  ("stone", "iron") -> 5,
  ("stone", "stone") -> 1)

  val mapDeviceCode = Map[String, Int]("diamond" -> 0, "iron" -> 1, "stone" -> 2)
  val mapCodeDeivce = mapDeviceCode.map(a => a._2 -> a._1)
  var min = Int.MaxValue

  def solution(picks: Vector[Int], minerals: Vector[String]): Int = {
    val mineralsSize = minerals.length
    val mMinerals = mutable.Seq(minerals.toSeq: _*)

    dfs(picks, mMinerals, mineralsSize, 0, 0)

    min
  }

  def dfs(picks: Seq[Int], minerals: mutable.Seq[String], mineralSize: Int, curIdx: Int, tiredScore: Int): Unit = {
    println("picks => " + picks.mkString(","))
    if(curIdx >= mineralSize || (picks(0) == 0 && picks(1) ==0 && picks(2) == 0)) {
        min = if(tiredScore < min) tiredScore else min
        return
      }

      if (picks(0) != 0) {
        val score = getTiredScore(0, minerals.slice(curIdx, curIdx + 5), tiredScore)
        println(s"0 => $score")
        val newPicks = Seq(picks(0)-1, picks(1), picks(2))
        dfs(newPicks, minerals, mineralSize, curIdx + 5, score)
      }
      if (picks(1) != 0) {
        val score = getTiredScore(1, minerals.slice(curIdx, curIdx + 5), tiredScore)
        println(s"1 => $score")
        val newPicks = Seq(picks(0), picks(1) - 1, picks(2))
        dfs(newPicks, minerals, mineralSize, curIdx + 5, score)
      }
      if (picks(2) != 0) {
        val score = getTiredScore(2, minerals.slice(curIdx, curIdx + 5), tiredScore)
        println(s"2 => $score")
        val newPicks = Seq(picks(0), picks(1), picks(2) - 1)
        dfs(newPicks, minerals, mineralSize, curIdx + 5, score)
      }
  }

  def getTiredScore(method: Int, fiveMinerals: mutable.Seq[String], baseNum: Int): Int = {
    fiveMinerals.foldLeft(0){case(res, target) =>
      res + scoreMap((mapCodeDeivce(method), target))
    } + baseNum
  }

  val minerals = Vector("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
//  minerals.slice(0, 5).foreach(println)

  println("tired =>" + solution(Vector(1,3,2), minerals))


}
