package c.x.codingtest.lps



object Q3 extends App {
  def solution(arr: Vector[Int], brr: Vector[Int]): Int = {
    import scala.collection._
    val arrA = mutable.Seq[Int]() ++ arr
    val arrB = mutable.Seq[Int]() ++ brr

    var cnt = 0
    var curA = 0
    var curB = 0
    for(i <- arrA.indices) {
      curA += arrA(i)
      curB += arrB(i)

      if(curA < curB) {
        cnt += 1
        arrA(i) = arrB(i)
      } else if (curA == curB) {
        // nothing to do
      } else {
        cnt +=1
        arrA(i) = arrB(i)
      }
    }
    cnt
  }

  println(solution(Vector(3,7,2,4), Vector(4,5,5,2)))
}
