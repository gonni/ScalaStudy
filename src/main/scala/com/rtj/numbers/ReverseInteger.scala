package com.rtj.numbers

import scala.annotation.tailrec

object ReverseInteger extends App {

  def reverseInteger(numberOri: Int): Int = {
    @tailrec
    def revert(number: Int, res: Int): Int = {
      if(number < 10) {
        val finValue = res + number
        if(finValue > Int.MaxValue) 0
        else finValue.toInt
      } else revert(number/10, (res + number % 10) * 10)
    }
    revert(numberOri, 0)
  }

  println(reverseInteger(123456))

}
