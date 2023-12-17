package c.x.codingtest.easy

object CompareTheTriplets extends App {
  def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
    val (l, r) = a.zip(b).map(t => {
      if(t._1 > t._2) (1, 0)
      else if(t._1 < t._2) (0, 1)
      else (0, 0)
    }).reduce((x, y) => (x._1 + y._1, x._2 + y._2))
    Array(l, r)
  }

  compareTriplets(Array[Int](17,28,30), Array[Int](99,16,8)).foreach(println)
}
