package com.rtj.graphs

import scala.annotation.tailrec

object GraphProblems extends App {
  type Graph[T] = Map[T, Set[T]]

  val socialNetwork: Graph[String] = Map(
    "Alice" -> Set("Bob", "Charlie", "David"),
    "Bob" -> Set(),
    "Charlie" -> Set("David"),
    "David" -> Set("Bob", "Mary"),
    "Mary" -> Set("Bob", "Charlie"),
    "Dan" -> Set()
  )

  def outDegree[T](graph: Graph[T], node: T): Int = graph(node).size

  def inDegree[T](graph: Graph[T], node:T):Int = graph.map(_._2.contains(node)).count(_ == true)

  def isPath[T](graph: Graph[T], start: T, end: T): Boolean = {

    @tailrec
    def isPathTailrec(remaining: List[T], visited: Set[T]): Boolean = {
      if(remaining.isEmpty) false
      else {
        val node = remaining.head
        if(node == end) true
        else if(visited.contains(node)) isPathTailrec(remaining.tail, visited)
        else isPathTailrec(remaining.tail ++ graph(node), visited + node)
      }
    }

    isPathTailrec(List(start), Set())
  }

  def findPath[T](graph: Graph[T], start: T, end: T): List[T] = {
    @tailrec
    def findPathTailrec(remaining: List[(T, List[T])], visited: Set[T]): List[T] = {
      if(remaining.isEmpty) List()
      else {
        val (node, currentPath) = remaining.head
        if(node == end) currentPath
        else if(visited.contains(node)) findPathTailrec(remaining.tail, visited)
        else {
          val neighbors = graph(node)
          val tuples = neighbors.map(n => (n, n :: currentPath))
          findPathTailrec(remaining.tail ++ tuples, visited + node)
        }
      }
    }

    findPathTailrec(List((start, List(start))), Set())
  }

//  def findCycle[T](graph: Graph[T], node: T): List[T] =


//  println(isPath(socialNetwork, "Alice", "Mary"))
//  println(isPath(socialNetwork, "Bob", "Mary"))
//  println(findPath(socialNetwork, "Alice", "Mary"))
}
