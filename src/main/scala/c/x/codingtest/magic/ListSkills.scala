package c.x.codingtest.magic

import scala.annotation.tailrec

object ListSkills extends App {
  val s = List(1,2,3,4,5)

//  println(s.sliding(2,3).mkString(","))
//  //List(1, 2),List(4, 5)
//
//  println(s.drop(3).mkString(","))
//  //4,5
//
//  println(s.partition(a => a % 2 == 0))
//  //(List(2, 4),List(1, 3, 5))
//  println(s.permutations.mkString(","))
//  //List(1, 2, 3, 4, 5),List(1, 2, 3, 5, 4),List(1, 2, 4, 3, 5),List(1, 2, 4, 5, 3),List(1, 2, 5, 3, 4),List(1, 2, 5, 4, 3)
//  println(s.forall(_ < 10))
//  println(s.forall(_ < 3))


  @tailrec
  def recSum(lst: List[Int], score: Int) : Int = {
    if(lst.isEmpty) score
    else {
      lst match {
        case head :: tail => recSum(tail, head + score)
        case _ => -1
      }
    }
  }
  println(recSum(s, 0))

  // permutation
  val lb = List(1,2,3,4,5)

  def perms(list: List[Int]): List[List[Int]] = {
    if (list.size == 1) List(list)
    else for {
      x <- list
      y <- perms(list.filterNot(_ == x))
    } yield x :: y
  }

  def perms2(list: List[Int]): List[List[Int]] = list match {
    case Nil => Nil
    case List(x) => List(List(x))
    case _ => list
      .flatMap(x =>
        perms2(list.filterNot(_==x))
          .map(p => x :: p))
  }

  println(perms(lb).mkString(","))

  // circle
  val tail = lb.take(3)
  val circled = lb.drop(3) ++ tail
  println(circled.mkString(","))

  // BFS
  // DFS

  // foldLeft
  lb.foldLeft(List.empty[Int]){case (lst, i) =>
    lst :+ i * 2
  }.foreach(println)
  // 2,4,6,8,10
  println(lb.foldLeft(0){case (fin, i) =>
    fin + i * 2
  })
  // 30

  // foldLeft for tuple
  val tl = List((1,2), (3,4), (5,6))

  val sum = tl.foldLeft((0,0)){case(a, b) => {
    (a._1+b._1, a._2+b._2)
  }}
  println("foldSum => " + sum)

  // tuple match case
  val c1 = List('a', 'b', 'c')
  val c2 = List('d', 'e', 'f')
  val c3 = List('b', 'a', 'e')

  @tailrec
  def canMake(c1: List[Char], c2: List[Char], c3: List[Char]): Boolean = {
    if(c3.isEmpty) true
    else
      (c1, c2) match {
        case (h :: t, _) if(h == c3.head) => canMake(t, c2, c3.tail)
        case (_, h :: t) if(h == c3.head) => canMake(c1, t, c3.tail)
        case _ => false
      }
  }
  println(canMake(c1, c2, c3))

  val str = "12345"


}
