package c.x.codingtest.mid

import c.x.codingtest.mid.DesertIsland.worldMap
import scala.reflect.ClassTag.Nothing
import scala.util.control.Breaks.{break, breakable}

object DesertIsland2 extends App {

  val dx = Array(-1,1,0,0)
  val dy = Array(0,0,-1,1)

  val ax = 3
  val ay = 5

  val visited : Array[Array[Boolean]] = Array.ofDim[Boolean](ax, ay)
  visited.map(_.map(_ => false))

  val worldMap: Array[Array[Int]] = Array.ofDim[Int](ax ,ay)
//  worldMap(0) = Array(-1, 5, 9, 1, -1)
//  worldMap(1) = Array(-1, 1, -1, 5, -1)
//  worldMap(2) = Array(-1, 2, 3, 1, -1)
//  worldMap(3) = Array(1, -1, -1, -1, 1)
  worldMap.map(_.map(_ => 0))
  worldMap(0) = Array(1,0,1,1,1)
  worldMap(1) = Array(1,0,1,0,0)
  worldMap(2) = Array(1,1,1,1,1)

  def solution(maps: Vector[String]): Vector[Int] = {
    Vector[Int]()
  }

  def bfs(x: Int, y: Int) = {
    import scala.collection._
    val q = mutable.Queue[(Int, Int)]()
    q.enqueue((x, y))

    while(q.nonEmpty) {
      val (nowX, nowY) = q.dequeue()

      for(i <- 0 until 4) {
        breakable {
          val nextX = nowX + dx(i)
          val nextY = nowY + dy(i)

          if (nextX < 0) break;
          if (nextY < 0) break;
          if (nextX >= ax) break;
          if (nextY >= ay) break;
//          nextX match {
//            case _  if nextX < 0 || nextX >= ax => break
//          }
//          nextY match {
//            case _ if nextY < 0 || nextY >= ay => break
//          }

          if(visited(nextX)(nextY)) break ;
          if(worldMap(nextX)(nextY) == -1) break ;

          q.enqueue((nextX, nextY))
          worldMap(nextX)(nextY) = worldMap(nowX)(nowY) + 1
          visited(nextX)(nextY) = true
        }
      }
    }
  }

  visited(0)(0) = true
  bfs(0,0)
  println(worldMap(ax-1)(ay-1))


  println("End Condition ..")



}
