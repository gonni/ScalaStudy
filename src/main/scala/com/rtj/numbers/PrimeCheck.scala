package com.rtj.numbers

import scala.annotation.tailrec

object PrimeCheck extends App {

  def isPrime(n: Int): Boolean = {

    @tailrec
    def primeCheckTailrec(acc: Int): Boolean = {
      if(acc > Math.sqrt(n)) true
      else if(n % acc == 0) {
        println("divided by " + acc)
        false
      }
      else primeCheckTailrec(acc + 1)
    }
    if(n == 0 || n == 1 || n == -1) false
    else primeCheckTailrec(2)
  }

  def decompose(n: Int): List[Int] = {
    def decomposeTailrec(remaining: Int) = {

    }
    List()
  }


  println(isPrime(-7))
}
