package c.x.codingtest.mid

object SeriesArraySum extends App {
  def solution(sequence: Vector[Int], k: Int): Vector[Int] = {
    var j = 0
    var i = 0
    var sum = 0
    var minIdx:(Int, Int) = (-1, -1);
    var minDist = Int.MaxValue;
    var isIgnoreAfter = false
    while(i < sequence.length && !isIgnoreAfter) {
      i += 1
//      println("-> " + i)
      if(sequence(i) <= k) {
        j = i
        while (sum < k && j < sequence.length) {
          sum += sequence(j)
          j += 1
        }

        if (sum == k) {
          val dist = Math.abs(j - 1 - i)
          println(i + "," + (j - 1))
          if (minDist > dist) {
            minDist = dist
            minIdx = (i, j - 1)
          }

          if(dist == 0) isIgnoreAfter = true
        }
      }
      sum = 0
    }
    Vector[Int](minIdx._1, minIdx._2)
  }

  solution(Vector[Int](1,1,1,2,3,4,5), 5).foreach(println)
}
