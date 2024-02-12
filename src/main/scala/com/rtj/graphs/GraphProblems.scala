package com.rtj.graphs

import scala.annotation.tailrec

object GraphProblems extends App {
  type Graph[T] = Map[T, Set[T]]

  val socialNetwork: Graph[String] = Map(
    "Alice" -> Set("Bob", "Charlie", "David"),
    "Bob" -> Set(),
    "Charlie" -> Set("David"),
    "David" -> Set("Bob", "Mary"),
    "Mary" -> Set("Bob", "Charlie")
  )

  def outDegree[T](graph: Graph[T], node: T): Int = graph(node).size

  def inDegree[T](graph: Graph[T], node:T):Int = graph.map(_._2.contains(node)).count(_ == true)

//  def isPath[T](graph: Graph[T], start: T, end: T): Boolean = {
////    graph(start).contains(end)
//
//    @tailrec
//    def pathTailrec(curTarget: List[T], visited: Set[T]): Boolean = {
//      if(curTarget.head == end) true
//      else {
//        val subs =  graph(curTarget.head)
//        if(visited.contains(subs.head))
//          pathTailrec(subs.tail :: curTarget.tail, visited + subs.head)
//        else
//
//      }
//    }
//
//  }

}
