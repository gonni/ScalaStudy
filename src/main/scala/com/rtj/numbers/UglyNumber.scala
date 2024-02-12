package com.rtj.numbers

import scala.annotation.tailrec

object UglyNumber {

  def uglyNumber(number: Int): Boolean =  {
    @tailrec
    def uglyTailrec(acc:Int): Boolean = {
      if(acc == 1) true
      else if(acc % 2 == 0) uglyTailrec(acc/2)
      else if(acc % 3 == 0) uglyTailrec(acc/3)
      else if(acc % 5 == 0) uglyTailrec(acc/5)
      else false
    }
    uglyTailrec(number)
  }

  def main(args: Array[String]): Unit = {
    println(uglyNumber(6))
    println(uglyNumber(25))
    println(uglyNumber(100))
    println(uglyNumber(14))
    println(uglyNumber(39))
  }


}
