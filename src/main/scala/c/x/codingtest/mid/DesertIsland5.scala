package c.x.codingtest.mid

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object DesertIsland5 extends App {
  def solution(maps: Vector[String]): Vector[Int] = {
    val wMap = for {
      s <- maps
    } yield s.toCharArray

    val ax = wMap.size
    val ay = wMap.head.length

    val visited = Array.ofDim[Boolean](ax, ay)
    visited.map(_.map(_ => false))

    val dx = Array(-1, 1, 0, 0)
    val dy = Array(0, 0, -1, 1)

    def checkLinkedIsland(x: Int, y: Int): Int = {
      println(s"check try : $x, $y")
      //visited(x)(y) = true
      var sum = 0
      import scala.collection._
      val stack = mutable.Stack[(Int, Int)]()
      stack.push((x, y))

      while (stack.nonEmpty) {
        val (nX, nY) = stack.pop()

        breakable {
          if (visited(nX)(nY)) break
          visited(nX)(nY) = true

          sum = sum +  wMap(nX)(nY).asDigit

          for (i <- 0 until 4) {
            breakable {
              val curX =nX + dx(i)
              val curY = nY + dy(i)

              if (curX < 0) break;
              if (curY < 0) break;
              if (curX >= ax) break;
              if (curY >= ay) break;
              if (visited(curX)(curY)) break;
              if (wMap(curX)(curY) == 'X') break;

              stack.push((curX, curY))
            }
          }
        }
      }
      sum
    }


    val ress = for {
      (row, i) <- wMap.zipWithIndex
      (col, j) <- row.zipWithIndex
    } yield (i, j, col)

    val fin = ress.map(r => r match {
      case _ if visited(r._1)(r._2) == true || r._3 == 'X' => -1
      case _ => checkLinkedIsland(r._1, r._2)
    }).filterNot(_ == -1).toVector.sortWith(_ < _)

    if (fin.isEmpty) Vector(-1) else fin
  }

  solution(Vector[String]("X591X", "X1X5X", "X231X", "1XXX1")).foreach(println)
  println("-----")
  solution(Vector[String]("XXX", "XXX", "XXX")).foreach(println)
}
