package c.x.codingtest.magic

import scala.util.control.Breaks.{break, breakable}

object DFSbFSmazeEjection extends App {

  def solution(maps: Vector[String]): Int = {
    val wMap = maps.map(_.toCharArray).toArray

    val startP = findPoint('S', wMap)
    val leverP = findPoint('L', wMap)
//    print(s"$startP --> $leverP :")

    val start2Lever = bfs('L', startP, wMap)
//    println(start2Lever)

    val endP = findPoint('E', wMap)
//    print(s"$leverP --> $endP :")

    val lever2End = bfs('E', leverP, wMap)
//    println(lever2End)
    if(start2Lever == 0 || lever2End == 0) -1 else start2Lever + lever2End
  }

  case class Node(x: Int, y: Int, value: Int)

  def DFS(ch: Char, start: (Int,Int), maps :Array[Array[Char]]): Int = {
    import scala.collection._
    val dx = Array(-1,1,0,0)
    val dy = Array(0,0,-1,1)



    val visited: Array[Array[Int]] = Array.ofDim[Int](maps.length, maps.head.length)
    visited.map(_.map(_ => 0))

    visited(start._1)(start._2) = 0
    //    Array.tabulate(5){a => false}
    var score = 0
    val stack = mutable.Stack[Node]()
    stack.push(Node(start._1, start._2, score))

    while(stack.nonEmpty) {
      val cur = stack.pop()

      if(maps(cur.x)(cur.y) == ch) {
        score = Math.min(score, cur.value)
      }

      for(i <- 0 until 4) {
        breakable {
          val x = cur.x + dx(i)
          val y = cur.y + dy(i)
          val count = cur.value

          if(x < 0 || y < 0
            || x >= maps.length || y >= maps.head.length
            || maps(x)(y) == 'X'
            || count >= visited(x)(y)
          ) break // continue for

          stack.push(Node(x, y, cur.value + 1))
          visited(x)(y) = Math.min(visited(x)(y), count)
        }
      }
    }
    score
  }

  def bfs(ch: Char, start: (Int,Int), maps :Array[Array[Char]]): Int = {
    import scala.collection._
    val dx = Array(-1,1,0,0)
    val dy = Array(0,0,-1,1)

    val q = mutable.Queue[Node]()
    q.enqueue(Node(start._1, start._2, 0))

    val visited : Array[Array[Boolean]] = Array.ofDim[Boolean](maps.length, maps.head.length)
    visited.map(_.map(_ => false))
    visited(start._1)(start._2) = true

    //    Array.tabulate(5){a => false}

    var score = 0
    while(q.nonEmpty) {
      val cur = q.dequeue()

      if(maps(cur.x)(cur.y) == ch) {
        score = Math.min(score, cur.value)
      }

      for(i <- 0 until 4) {
        breakable {
          val x = cur.x + dx(i)
          val y = cur.y + dy(i)

          if(x < 0 || y < 0
            || x >= maps.length || y >= maps.head.length
            || maps(x)(y) == 'X'
            || visited(x)(y)
          ) break // continue for

          visited(x)(y) = true
          q.enqueue(Node(x, y, cur.value + 1))
        }
      }
    }
    score
  }

  def findPoint(findChar: Char, mzMap: Array[Array[Char]]): (Int, Int) = {
    for{
      (row, rowIdx) <- mzMap.zipWithIndex
      col <- row if row.contains(findChar)
    } yield (rowIdx, row.indexOf(findChar))
  }.head

  val mapSample = Vector("SOOOL","XXXXO","OOOOO","OXXXX","OOOOE")

  println("result ->" + solution(mapSample))
  println("result ->" + solution(Vector("LOOXS","OOOOX","OOOOO","OOOOO","EOOOO")))
}
