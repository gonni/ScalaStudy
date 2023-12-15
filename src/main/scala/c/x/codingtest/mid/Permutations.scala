package c.x.codingtest.mid

object Permutations {

  def generatePermutations(numbers: List[Int]): List[List[Int]] = {
    numbers match {
      case Nil => List(Nil)
      case _ =>
        for {
          number <- numbers
          remainingNumbers = numbers.filterNot(_ == number)
          permutation <- generatePermutations(remainingNumbers)
        } yield number :: permutation
    }
  }

//  def generatePermutations2(numbers: List[Int]): List[List[Int]] = {
//    numbers.
////    numbers match {
////      case Nil => List(Nil)
////      case _ =>
////        for {
////          number <- numbers
////          remainingNumbers = numbers.filterNot(_ == number)
////          permutation <- generatePermutations(remainingNumbers)
////        } yield number :: permutation
////    }
//  }

  def getNextGreaterNumber(w: String) = {
    val descOrder = w.toCharArray.sortWith(_ < _)
    descOrder.zipWithIndex.foreach(println)


  }

  def main(args: Array[String]): Unit = {
//    val numbers = List(3, 4, 2, 1)
//    val numbers = List(1, 2, 3, 4)
    val numbers = List('d', 'k', 'h', 'c').sortWith(_ < _)
    numbers.foreach(println)
//    val permutations = generatePermutations(numbers)
//
//    println("All permutations:")
//    permutations.foreach(perm => println(perm.mkString(", ")))

//    val a = List.fill(4)(0 to 3).flatten.combinations(4).flatMap(_.permutations)
//    a.foreach(println)



    val a = numbers
      .permutations
      .filter(a => a.mkString.compare("dkhc") > 0)
      .take(1)
      .toSeq.head.mkString




    println(a)
//    getNextGreaterNumber("3421")
  }
}