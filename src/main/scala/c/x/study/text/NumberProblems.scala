package c.x.study.text

import scala.annotation.tailrec

object NumberProblems extends App {
  def isPrime(n: Int): Boolean = {
    @tailrec
    def divide(divid: Int): Boolean = {
      if(n % divid == 0) false
      else if(divid <= n/2) divide(divid + 1)
      else true
    }

    divide(2)
  }

  println(isPrime(13))
  println(isPrime(4))
  println(isPrime(5))
  println(isPrime(19))

  println(Math.sqrt(100))
}
