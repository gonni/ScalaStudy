package com.rtj.numbers

import scala.annotation.tailrec

object Duplicates {
  def findNonDup(remList: List[Int]) = {

    @tailrec
    def dupCheck(remm: List[Int], map:Map[Int, Int]): Int = {
      if(remm.isEmpty) map.filter(_._2 == 1).head._1
      else {
        val cur = remm.head
        val cntCur = map.getOrElse(cur, 0)
        dupCheck(remm.tail, map + (cur -> (cntCur + 1)))
      }
    }

    dupCheck(remList, Map[Int, Int]())
  }

  def main(args: Array[String]): Unit = {
    println(findNonDup(List(1,2,3,4,5,1,2,3,4)))
  }
}
