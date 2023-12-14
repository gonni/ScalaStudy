package c.x.codingtest.mid

object NonDivisibleSubset extends App {
  def nonDivisibleSubset(k: Int, s: Array[Int]): Int = {
    // Write your code here

    for(i <- 0 to s.length -2) {
      for(j <- i+1 to s.length-1) {
        if((s(i) + s(j)) % k == 0) {
          
        }
      }
    }


    -1
  }
}
