package c.x.codingtest.easy

import scala.annotation.tailrec

object UtopiaTree extends App {


  def utopianTree(n: Int): Int = {
    @tailrec
    def getHeight(targetTurn: Int, period: Int = 0, height: Int = 0): Int = {
      val newHeight = if(period % 2 == 0) height + 1 else height * 2
      if(targetTurn < 0) height
      else getHeight(targetTurn - 1, period + 1, newHeight)
    }
    getHeight(n)
  }

  println(utopianTree(5))

}
