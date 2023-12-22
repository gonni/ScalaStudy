package c.x.codingtest.mid

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object DesertIsland3 extends App {
  def solution(maps: Vector[String]): Vector[Int] = {
    val wMap = for {
      s <- maps
    } yield s.toCharArray

    val ax = wMap.size
    val ay = wMap.head.length

    val visited = Array.ofDim[Boolean](ax, ay)
    visited.map(_.map(_ => false))

    //    wMap.zipWithIndex.map((arri) => {
    //      arri._1.zipWithIndex.map(arrj => {
    //        if(arrj._1 == 'X') visited(arri._2)(arrj._2) = true
    //      })
    //    })

    val dx = Array(-1, 1, 0, 0)
    val dy = Array(0, 0, -1, 1)

    def checkLinkedIsland(x: Int, y: Int, sum: Int = 0): Int = {
      println(s"check try : $x, $y, $sum")
      visited(x)(y) = true

      var res = sum
      for (i <- 0 until 4) {
        breakable {
          val nX = x + dx(i)
          val nY = y + dy(i)

          if (nX < 0) break;
          if (nY < 0) break;
          if (nX >= ax) break;
          if (nY >= ay) break;
          if (visited(nX)(nY)) break;
          if (wMap(nX)(nY) == 'X') break;

          res = checkLinkedIsland(nX, nY, sum + wMap(nX)(nY).asDigit)
        }
      }
      res
    }

    val ress = for {
      (row, i) <- wMap.zipWithIndex
      (col, j) <- row.zipWithIndex
    } yield (i, j, col)

    val fin = ress.map(r => r match {
      case _ if visited(r._1)(r._2) == true || r._3 == 'X' => -1
      case _ => checkLinkedIsland(r._1, r._2, r._3.asDigit)
    }).filterNot(_ == -1).toVector.sortWith(_ < _)

    if (fin.isEmpty) Vector(-1) else fin
  }

  solution(Vector[String]("X591X", "X1X5X", "X231X", "1XXX1")).foreach(println)
  println("-----")
  solution(Vector[String]("XXX", "XXX", "XXX")).foreach(println)

}

