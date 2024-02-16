package c.x.programers

import scala.annotation.tailrec

object DivString {
  def solution(s: String): Int = {

    @tailrec
    def checkTailRec(remaining: String, map: Map[Char, Int], acc: Int): Int = {
      if(remaining.isEmpty) {
        if(map.isEmpty) acc else acc + 1
      } else {
        val cur = remaining.head
        val targetVal = map.getOrElse(cur, 0) + 1

        if(map.values.toSet.contains(targetVal))
          checkTailRec(remaining.tail, Map(), acc + 1)
        else
          checkTailRec(remaining.tail, map + (cur -> targetVal), acc)
      }
    }
    checkTailRec(s, Map[Char, Int](), 0)
  }

  def solution2(s: String): Int = {
    def loop(s: String, cur: Int, acc: Int): Int = {
      if (cur >= s.size) acc
      else {
        val (a, b) = s.take(cur).partition(_ == s.head)
        if (a.size == b.size) loop(s.drop(cur), 1, acc + 1)
        else                  loop(s, cur + 1, acc)
      }
    }

    loop(s, 1, 0) + 1
  }

  def main(args: Array[String]): Unit = {
//    println(solution("a"))
    println(solution("aabcddnaaaaccbb")) // -> 4 : aabc ddnaa aacc bb
    println(solution("aaaabbbcaaaa")) // ->2
//    println(solution2("abaabab"))
//    println(solution2("banana"))
//    println(solution2("abracadabra"))
//    println(solution2("aaabbaccccabba"))

  }
}
