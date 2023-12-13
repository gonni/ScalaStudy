package c.x.codingtest.mid

import scala.annotation.tailrec

object ExtraLongFactorials extends App {
  def extraLongFactorials(n: Int) = {
    // Write your code here
    @tailrec
    def multi(n: Int, mulVal: BigInt = 1): BigInt = {
      if(n < 1) return mulVal
      val rVal: BigInt = mulVal * n
      multi(n - 1, rVal)
    }

    print(multi(n))
  }

  extraLongFactorials(30)
//  println("->" + extraLongFactorials(30))
}
