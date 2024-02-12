package com.rtj.trees

import scala.annotation.tailrec
import scala.collection.immutable.Queue

sealed abstract class BTree[+T] {
  def value: T
  def left: BTree[T]
  def right: BTree[T]
  def isEmpty: Boolean

  def isLeaf: Boolean
  def collectLeaves: List[BTree[T]]
  def leafCount: Int

  def size: Int

  def collectNodes(level: Int): List[BTree[T]]

  def mirror: BTree[T]

//  def sameShapeAs[S >: T](that: BTree[S]): Boolean
  def toList: List[T]
}

case object BEnd extends BTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException()
  override def left: BTree[Nothing] = throw new NoSuchElementException()
  override def right: BTree[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false
  override def collectLeaves: List[BTree[Nothing]] = List()
  override def leafCount: Int = 0

  override val size: Int = 0

  override def collectNodes(level: Int): List[BTree[Nothing]] = List()

  override def mirror: BTree[Nothing] = BEnd

//  override def sameShapeAs[S >: Nothing](that: BTree[S]): Boolean = ???

  override def toList: List[Nothing] = List()
}

case class BNode[+T](override val value: T, override val left: BTree[T], override val right: BTree[T])
  extends BTree[T] {
  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = left.isEmpty && right.isEmpty
  override def collectLeaves: List[BTree[T]] = {
    @tailrec
    def collectLeavesTailrec(todo: List[BTree[T]], leaves: List[BTree[T]]): List[BTree[T]] = {
      if(todo.isEmpty) leaves
      else if(todo.head.isEmpty) collectLeavesTailrec(todo.tail, leaves)
      else if(todo.head.isLeaf) collectLeavesTailrec(todo.tail, todo.head :: leaves)
      else {
        val node = todo.head
        collectLeavesTailrec(node.left :: node.right :: todo.tail, leaves)
      }
    }
    collectLeavesTailrec(List(this), List[BTree[T]]())

  }
  override def leafCount: Int = collectLeaves.length

  override val size: Int = 1 + left.size + right.size

  override def collectNodes(level: Int): List[BTree[T]] = {
//    @tailrec
//    def collectNodesTailrec(cLevel: Int, cNode: List[BTree[T]], collect: List[BTree[T]]): List[BTree[T]] = {
//      if(cLevel == 0) collect
//      else if(cLevel == 1) {
//        cNode.foldLeft(List[BTree[T]]()){(acc, cn) =>
//          if(cn.isEmpty || cn.isLeaf) acc
//          else if(cn.left.isEmpty && cn.right.isEmpty) acc
//          else if(!cn.left.isEmpty && cn.right.isEmpty) cn.left :: acc
//          else if(cn.left.isEmpty && !cn.right.isEmpty) cn.right :: acc
//          else cn.left :: cn.right :: acc
//        }
//      }
//      else {
//        collectNodesTailrec(cLevel -1, cNode.flatMap(cn => List(cn.right) :+ cn.left), collect)
//      }
//    }
//    collectNodesTailrec(level, List(this), List())

    @tailrec
    def collectNodesTailrec(cLv: Int, cNodes: List[BTree[T]]): List[BTree[T]] = {
      if(cNodes.isEmpty) List()
      else if(cLv == level) cNodes
      else {
        val nextRoot = for {
          node <- cNodes
          child <- List(node.left, node.right) if !child.isEmpty
        } yield child

        collectNodesTailrec(cLv + 1, nextRoot)
      }
    }
    collectNodesTailrec(0, List(this))
  }

  override def mirror: BTree[T] = {

    BEnd
  }

//  override def sameShapeAs[S >: T](that: BTree[S]): Boolean = ???

  override def toList: List[T] = {
    def preOrderedStack(root: BTree[T]): List[T]= {
      if(root.isEmpty) List()
      else root.value :: preOrderedStack(root.left) ++ preOrderedStack(root.right)
    }

    @tailrec
    def preOrderTailRec(stack: List[BTree[T]], visited: Set[BTree[T]] = Set(), acc: Queue[T] = Queue()): List[T] =
      if(stack.isEmpty) acc.toList
      else {
        val node = stack.head
        if(node.isEmpty) preOrderTailRec(stack.tail, visited, acc)
        else if(node.isLeaf || visited.contains(node)) preOrderTailRec(stack.tail, visited, acc :+ node.value)
        else preOrderTailRec(node :: node.left :: node.right :: stack.tail, visited + node, acc)
      }


//    preOrderedStack(this)
    preOrderTailRec(List(this))
  }
}

object BinaryTreeProblems extends App {

  val root = BNode(1,
    BNode(2,
      BNode(3, BEnd, BEnd),
      BNode(4,
        BEnd,
        BNode(5, BEnd, BEnd)
      )
    ),
    BNode(6,
      BNode(7, BEnd, BEnd),
      BNode(8, BEnd, BEnd)
    )
  )

//  println(root.collectLeaves)
//  println(root.leafCount)
//  println(root.size)
//  println(root.collectNodes(3).map(_.value))

  println(root.toList)

}
