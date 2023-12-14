package c.x.codingtest.mid

object Permutations {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val permutations = generatePermutations(numbers)

    println("All permutations:")
    permutations.foreach(perm => println(perm.mkString(", ")))
  }

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
}