package c.x.programers

import scala.annotation.tailrec

object ArmorKnight extends App {

//  def solution(number: Int, limit: Int, power: Int): Int = {
//    val knights = (1 to number)
//    val primes = knights.filter(isPrimes)//.sortWith(_ > _)
////    primes.foreach(println)
//    knights.foldLeft(0){case(sum, n) => {
//      val cntPrimes = primes.indexWhere(_ > n)
//      println(n + "->" + cntPrimes)
//      val iron = if(cntPrimes > limit) power else cntPrimes
//      sum + iron
//    }
//    }
//  }
//
//  def isPrimes(n: Int): Boolean = {
//    @tailrec
//    def isPrimeTailrec(acc: Int) : Boolean = {
//      if(acc > Math.sqrt(n)) true
//      else if(n % acc == 0) false
//      else isPrimeTailrec(acc + 1)
//    }
////    if(n == 1) true
////    else isPrimeTailrec(2)
//    isPrimeTailrec(2)
//  }

  def solution(number: Int, limit: Int, power: Int): Int = {
    val knights = 1 to number
    knights.foldLeft(0){ case(acc, n) =>
      val cntOfYak = cntYak(n)
      val ironWeight = if(cntOfYak > limit) power else cntOfYak
      acc + ironWeight
    }
  }

  def cntYak(n: Int): Int = {
    @tailrec
    def getYakTailrec(cur: Int, acc: Int): Int = {
      if(n/2 < cur) acc + 1
      else if(n % cur == 0) getYakTailrec(cur + 1, acc + 1)
      else getYakTailrec(cur + 1, acc)
    }
    if(n == 1) 1
    else getYakTailrec(2, 1)
  }


//  for(i <- 1 to 5)
//    println(i + "->" + cntYak(i))
  println("result =>" + solution(10, 3, 2))
}
