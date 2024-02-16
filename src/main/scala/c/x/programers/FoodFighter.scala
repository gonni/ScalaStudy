package c.x.programers

object FoodFighter extends App {
  def solution(food: Vector[Int]): String = {
    val ser = food.tail.map(_/2).zipWithIndex.map(v => {
      val cal = v._2 + 1
      val cnt = v._1
      (0 until  cnt).foldLeft[Seq[Int]](Seq())((a, b) => a :+ cal).mkString
    }).mkString
    ser + "0" + ser.reverse
  }

  println(solution(Vector(1,7,1,2)))
}
