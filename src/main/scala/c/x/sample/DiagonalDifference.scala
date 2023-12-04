package c.x.sample

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

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
//
//  def main(args: Array[String]): Unit = {
//
//  }

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
