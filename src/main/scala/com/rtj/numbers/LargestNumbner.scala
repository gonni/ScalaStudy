package com.rtj.numbers

import scala.annotation.tailrec

object LargestNumbner extends App {
  def largestNumbner(numbners: List[Int]): String = {
    val maxNum = numbners.max
    val maxLen = getLength(maxNum, 1)

    numbners.sortWith((a, b) => getLenAppNum(a, maxLen) > getLenAppNum(b, maxLen)).mkString("|")
  }

  def getLenAppNum(n: Int, maxLen: Int) = {
    val curLen = getLength(n, 1)
    if(maxLen == curLen) n
    else n * Math.pow(10, maxLen - curLen)
  }

  @tailrec
  def getLength(num: Int, len: Int): Int = {
    if(num < 10) len
    else getLength(num/10, len + 1)
  }

  println("=>" + largestNumbner(List(11,2,82,900, 901, 91)))
}
