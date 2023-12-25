package c.x.codingtest.mid

import scala.collection._

object SerialArraySum2 extends App {
//  def solution(sequence: Vector[Int], k: Int): Vector[Int] = {
//
//    var result = mutable.Seq[(Int, Int)]()
//    var winSum = 0
//
//    var winStartIdx = 0
//    var winEndIdx = 0
//
//    var minDistance = Int.MaxValue
//    var rangeIdx :Tuple2[Int, Int] = (0, 0)
//    while (winStartIdx <= winEndIdx
//      && winEndIdx < sequence.length
//      && winStartIdx < sequence.length
//      && winEndIdx < sequence.length ) {
//
//      winSum += sequence(winEndIdx)
//
//      while (winSum <= k && winStartIdx < sequence.length-1 && winEndIdx < sequence.length-1) {
//        if (winSum < k) {
//          winEndIdx += 1
//          winSum += sequence(winEndIdx)
//        }
//        if (winSum == k) {
//          minDistance = if(winEndIdx - winStartIdx < minDistance) {
//            rangeIdx = (winStartIdx, winEndIdx)
//            winEndIdx - winStartIdx
//          } else minDistance
//          result.appended(winStartIdx, winEndIdx)
//          winSum -= sequence(winStartIdx)
//          winStartIdx += 1
//        }
//      }
//
//      while (winSum > k && winStartIdx <= winEndIdx) {
//        winSum -= sequence(winStartIdx)
//        winStartIdx += 1
//
//        if (winSum == k) {
//          minDistance = if(winEndIdx - winStartIdx < minDistance) {
//            rangeIdx = (winStartIdx, winEndIdx)
//            winEndIdx - winStartIdx
//          } else minDistance
//          result.appended(winStartIdx, winEndIdx)
//          winSum -= sequence(winStartIdx)
//          winStartIdx += 1
//        }
//      }
//      winEndIdx +=1
//    }
//    Vector[Int](rangeIdx._1, rangeIdx._2)
//  }

  def solution(sequence: Vector[Int], k: Int): Vector[Int] = {
    def updateAnswer(left: Int, right: Int, result: Vector[Int]): Vector[Int] = {
      if (right - left - 1 < result(1) - result(0)) {
        Vector(left, right - 1)
      } else result
    }

    def loop(left: Int, right: Int, sum: Int)(result: Vector[Int]): Vector[Int] = {
      if (left >= right) return result

      if (sum == k) {
        loop(left + 1, right, sum - sequence(left))(updateAnswer(left, right, result))
      } else if (sum > k) {
        loop(left + 1, right, sum - sequence(left))(result)
      } else if (right < sequence.length) {
        loop(left, right + 1, sum + sequence(right))(result)
      } else return result
    }

    loop(0, 1, sequence(0))(Vector(0, sequence.length - 1))
  }

  solution(Vector(1, 2, 3, 4, 5), 7).foreach(println)
//
//  println("----------->")
  solution(Vector(1, 1, 1, 2, 3, 4, 5), 5).foreach(println)
//  println("----------->")
  solution(Vector(2,2,90,2,2,2), 6).foreach(println)

}
