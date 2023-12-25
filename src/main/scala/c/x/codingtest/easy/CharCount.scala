package c.x.codingtest.easy

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object CharCount extends App {

  def solution(s: String): Int = {
    var cnt = 0
    var hMap = mutable.HashMap[Char, Int]()

    for(ch <- s.toCharArray) {
      hMap.put(ch, hMap.get(ch).getOrElse(0) + 1)
      println(hMap)
      if(checkSameCount(hMap)) {
        hMap.clear()
        cnt += 1
      }
    }
    if(hMap.nonEmpty) 1 + cnt else cnt
  }

  def checkSameCount(hMap: mutable.HashMap[Char, Int]): Boolean = {
    val lst = hMap.map(t => t._2).toSeq.sorted

    var pre = -1
    var result = false;
    breakable {
      for (i <- lst) {
        if (pre == i) {
          result = true
          break ;
        }
        pre = i
      }
    }
    result
  }

  println(solution("abaababcde"))
  println(solution("abracadabra"))
  println(solution("aaabbaccccabba"))

  val x = "aaabbaccccabba"
  x.sliding(3).foreach(println)
  println(x.partition(_ == x.head))


}
