package com.rtj.Strings

import scala.annotation.tailrec

object AnagramCheck extends App {
  def checkAnagrams(sa: String, sb: String): Boolean = {
    @tailrec
    def checkSameRec(cur: String): Boolean = {
      if(cur.length == 0) false
      else if(sb.contains(cur.head)) true
      else checkSameRec(cur.tail)
    }
    checkSameRec(sa)
  }

  println(checkAnagrams("Scala", "TrAumA"))
  println(checkAnagrams("Scala", "TraumA"))
}
