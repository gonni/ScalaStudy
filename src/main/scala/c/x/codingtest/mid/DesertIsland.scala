package c.x.codingtest.mid

import scala.reflect.ClassTag.Nothing
import scala.util.control.Breaks.{break, breakable}


object DesertIsland extends App {

  val dx = Array(-1,1,0,0)
  val dy = Array(0,0,-1,1)


  val visited : Array[Array[Boolean]] = Array.ofDim[Boolean](3,5)
  visited.map(_.map(_ => false))

  val worldMap: Array[Array[Int]] = Array.ofDim[Int](3,5)
  worldMap.map(_.map(_ => 0))
  worldMap(0) = Array(1,0,1,1,1)
  worldMap(1) = Array(1,0,1,0,0)
  worldMap(2) = Array(1,1,1,1,1)

  val n = worldMap.length
  val m = worldMap.map(_.length).head

  def solution(maps: Vector[String]): Vector[Int] = {
    Vector[Int]()
  }

  // https://wiselog.tistory.com/163
  def bfs(x: Int, y: Int) = {
    import scala.collection._
    val q = mutable.Queue[(Int,Int)]()
    q.enqueue((x, y))

    def isBreakable(t1: Tuple2[Int, Int]) = t1 match {
      //    case t1._1 < 0 | t1._2 <0 | t1._1 > 10 | t1._2 > 10 => break ;
      case _ if t1._1 < 0 || t1._2 <0 || t1._1 >= n || t1._2 >= m => break
      case _ => Nothing
    }

    while(q.nonEmpty) {
      println("q->" + q)
      val (nowX, nowY) = q.dequeue()
      println(s"check-> ($nowX, $nowY)")
      breakable {
        for (i <- 0 until 4) {
//          println("start " + i)
          breakable {
            val nextX = nowX + dx(i)
            val nextY = nowY + dy(i)
//            println(s"nX:nY = $nextX:$nextY" )

            if (nextX < 0) break;
            if (nextY < 0) break;
            if (nextX >= n) break;
            if (nextY >= m) break;
            isBreakable((nextX, nextY)) // continue -- boundary check

            if (visited(nextX)(nextY)) break ;  // continue
            if (worldMap(nextX)(nextY) == 0) break; // continue

            q.enqueue((nextX, nextY))
            worldMap(nextX)(nextY) = worldMap(nowX)(nowY) + 1
            visited(nextX)(nextY) = true
          }
//          if(i == 3) break
        }
      }
    }
  }

  visited(0)(0) = true
  bfs(0,0)
  println(worldMap(n-1)(m-1))

}
