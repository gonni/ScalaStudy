package com.rtj.Strings

import scala.annotation.tailrec

object CountChars extends App {
  def countChars(s: String): Map[Char, Int] = {
    @tailrec
    def countRec(cur: String, cntMap: Map[Char, Int]): Map[Char, Int] = {
      if(cur.length == 0) cntMap
      else if(cntMap.contains(cur.head)) {
        val newCntMap = cntMap + (cur.head -> (cntMap(cur.head) + 1))
        countRec(cur.tail, newCntMap)
      } else {
        countRec(cur.tail, cntMap + (cur.head -> 1))
      }
    }

    countRec(s, Map[Char, Int]())
  }

  println("Count of chars => " + countChars("aaabccddef"))
}
