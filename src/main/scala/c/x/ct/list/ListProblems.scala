package c.x.ct.list

import scala.annotation.tailrec

object ListProblems extends App {

  trait RList[+T] {
    def head: T
    def tail: RList[T]
    def isEmpty: Boolean

    def ::[S >: T](elem: S): RList[S] = new ::(elem, this)
  }

  case object RNil extends RList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException()
    override def tail: RList[Nothing] = throw new NoSuchElementException()
    override def isEmpty: Boolean = true

//    override def prepend[S >: Nothing](elem: S): RList[S] = new Cons(elem, this)
  }

  case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
    override def isEmpty: Boolean = false
    override def toString: String = {
      @tailrec
      def toStringTailrec(remaining: RList[T], result: String): String = {
        if(remaining.isEmpty) result
        else if(remaining.tail.isEmpty) s"$result${remaining.head}"
        else toStringTailrec(remaining.tail, s"$result${remaining.head}, ")
      }

      "[" + toStringTailrec(this, "") + "]"
    }

//    override def prepend[S >: T](elem: S): RList[S] = Cons(elem, this)
  }

  val smallList = ::(1, ::(2, ::(3, RNil)))
  val newList = 1 :: 2 :: 3 :: RNil
  println(newList)
}
