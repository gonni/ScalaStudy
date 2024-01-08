package com.rtj.ListAnalysis

import scala.annotation.tailrec

sealed abstract class RList[+T] {
  def head: T
  def tail: RList[T]
  def isEmpty: Boolean
//  def headOption: Option[T]
  def ::[S >: T](elem: S): RList[S] = new ::(elem, this)
  def apply(index: Int): T
  def length: Int
  def reverse: RList[T]
  def ++[S >: T](anotherList: RList[S]): RList[S]
  def removeAt(index: Int): RList[T]
  def map[S](f: T=>S): RList[S]
  def flatMap[S](f: T=> RList[S]): RList[S]
  def betterFlatMap[S](f: T=> RList[S]): RList[S]
  def filter(f: T=> Boolean): RList[T]
  def rle: RList[(T, Int)]
}

case object RNil extends RList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: RList[Nothing] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true

  //  override def headOption: Option[Nothing] = ???
  override def toString: String = "[]"

  override def apply(index: Int): Nothing = throw new NoSuchElementException()

  override def length: Int = 0

  override def reverse: RList[Nothing] = this

  def ++[S >:Nothing](anotherList: RList[S]): RList[S] = anotherList

  override def removeAt(index: Int): RList[Nothing] = this

  override def map[S](f: Nothing => S): RList[S] = throw new NoSuchElementException()

  override def flatMap[S](f: Nothing => RList[S]): RList[S] = throw new NoSuchElementException()
  override def filter(f: Nothing => Boolean): RList[Nothing] = this

  override def rle: RList[(Nothing, Int)] = RNil

  override def betterFlatMap[S](f: Nothing => RList[S]): RList[S] = RNil
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def toString: String = {
    @tailrec
    def toStringTailRec(remaining: RList[T], result: String): String = {
      if(remaining.isEmpty) result
      else if(remaining.tail.isEmpty) s"$result${remaining.head}"
      else toStringTailRec(remaining.tail, s"$result${remaining.head}, ")
    }

    "[" + toStringTailRec(this, "") + "]"
  }

  override def apply(index: Int): T = {
    @tailrec
    def getElementTrailRec(remaining: RList[T], curIndex: Int): T = {
      if(curIndex == index) remaining.head
      else getElementTrailRec(remaining.tail, curIndex+1)
    }
    if(index <0 ) throw new NoSuchElementException()
    else getElementTrailRec(this, 0)
  }

  override def length: Int = {
    @tailrec
    def getAllCount(remaining: RList[T], index: Int): Int = {
      if(remaining.isEmpty) index
      else getAllCount(remaining.tail, index + 1)
    }
    getAllCount(this, 0)
  }

  override def reverse: RList[T] = {
    @tailrec
    def backTailrec(remaining: RList[T], result: RList[T]): RList[T] = {
      if(remaining.isEmpty) result
      else {
        backTailrec(remaining.tail,  remaining.head :: result)
      }
    }

    backTailrec(this, RNil)
  }

  override def ++[S >: T](anotherList: RList[S]): RList[S] = {
    @tailrec
    def concatList(remaining: RList[S], result: RList[S]) : RList[S] = {
      if(remaining.isEmpty) result
      else concatList(remaining.tail, remaining.head :: result )
    }
    concatList(this.reverse, anotherList)
  }

  override def removeAt(index: Int): RList[T] = {
    @tailrec
    def removingTailrec(remaining: RList[T], acc: RList[T], curIndex: Int): RList[T] = {
      if (remaining.isEmpty) acc.reverse
      else if(index == curIndex) acc.reverse ++ remaining.tail
      else removingTailrec(remaining.tail, remaining.head :: acc, curIndex + 1)
    }

    removingTailrec(this, RNil, 0)
  }

  override def map[S](f: T => S): RList[S] = {
    @tailrec
    def mapping(remaining: RList[T], result: RList[S]): RList[S] = {
      if(remaining.isEmpty) result
      else {
        mapping(remaining.tail, f(remaining.head) :: result)
      }
    }
    mapping(this, RNil).reverse
  }

  // TOO SLOW
  override def flatMap[S](f: T => RList[S]): RList[S] = {
    @tailrec
    def fmapping(remaining: RList[T], result: RList[S]): RList[S] = {
      if(remaining.isEmpty) result.reverse
      else{
        fmapping(remaining.tail, f(remaining.head).reverse ++ result)
      }
    }
    fmapping(this, RNil)
  }



  override def filter(f: T => Boolean): RList[T] = {
    @tailrec
    def filtering(remaing: RList[T], acc: RList[T]): RList[T] = {
      if(remaing.isEmpty) acc.reverse
      else{
        if(f(remaing.head)) filtering(remaing.tail, remaing.head :: acc)
        else filtering(remaing.tail, acc)
      }
    }
    filtering(this, RNil)
  }

  override def rle: RList[(T, Int)] = ???

  override def betterFlatMap[S](f: T => RList[S]): RList[S] = ???
}

object RList {
  def from[T] (interable: Iterable[T]): RList[T] = {
    def convertToRListTailrec(reamining: Iterable[T], acc: RList[T]): RList[T] = {
      if(reamining.isEmpty) acc
      else convertToRListTailrec(reamining.tail, reamining.head :: acc)
    }

    convertToRListTailrec(interable, RNil).reverse
  }
}

object ListProblems extends App {
  // ending of colon, right associative
  val aSmallList = ::(1, ::(2, ::(3, RNil)))
  val newList = 1 :: 2 :: 3 :: RNil
//  println(aSmallList)
  val anotherList = 4 :: 5 :: 6 :: RNil

//  println(newList(1))
//  println("length => " + newList.length)
//  println(newList.reverse)
//  println(newList ++ anotherList)

  val bigList = RList.from(0 to 10)
//  println(bigList)
//  println(bigList.removeAt(3))

  val mapped = bigList.map(a => "D" + a)
  println(mapped)

  val fmapped = bigList.flatMap(a => 2 :: a :: RNil)
  println(fmapped)

  val ffiltered = bigList.filter(_ > 5)
  println(ffiltered)

}
