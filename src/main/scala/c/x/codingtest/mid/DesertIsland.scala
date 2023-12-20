package c.x.codingtest.mid

import scala.util.control.Breaks.{break, breakable}


object DesertIsland extends App {

  val dx = Array(-1,1,0,0)
  val dy = Array(0,0,-1,1)


  val visited : Array[Array[Boolean]] = Array.ofDim[Boolean](3,4)
  visited.map(_.map(_ => false))

  val worldMap: Array[Array[Int]] = Array.ofDim[Int](3,4)
  worldMap.map(_.map(_ => 0))
  worldMap(0) = Array(1,0,1,1)
  worldMap(1) = Array(1,0,1,0)
  worldMap(2) = Array(1,1,1,1)

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


    while(q.nonEmpty) {
      val (nowX, nowY) = q.dequeue()
      breakable {
        for (i <- 0 until 4) {
          println("start " + i)
          breakable {
            val nextX = nowX + dx(i)
            val nextY = nowY + dy(i)
            println(s"nX:nY = $nextX:$nextY" )

            if (nextX < 0) break;
            if (nextY < 0) break;
            if (nextX >= n) break;
            if (nextY >= m) break;

            if (visited(nextX)(nextY)) break ;
            if (worldMap(nextX)(nextY) == 0) break;

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
