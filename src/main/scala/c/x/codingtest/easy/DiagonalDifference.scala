package c.x.codingtest.easy

import java.io._
import scala.io._

object DiagonalDifference {

  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here
    def getSum(arr: Array[Array[Int]]): Int = {
      arr.zipWithIndex.map(iArr => {
        val idx = iArr._2
        iArr._1(idx)
      }).sum
    }

    Math.abs(getSum(arr) - getSum(arr.reverse))
  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = diagonalDifference(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
