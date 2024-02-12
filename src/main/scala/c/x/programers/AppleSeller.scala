package c.x.programers

object AppleSeller {

  def solution(k: Int, m: Int, score: Vector[Int]): Int = {
    val packages = score.sortWith(_ > _).sliding(m, m)
    packages.map(a => if(a.length == m) a.min * m else 0).sum
  }

  def main(args: Array[String]): Unit = {
    val score = Vector(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)
    println(solution(4, 3, score))
  }
}
