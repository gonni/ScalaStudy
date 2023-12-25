package c.x.codingtest.magic

object LittlePartialString extends App {
  def solution(t: String, p: String): Int = {
    val sizeT = t.length
    var cnt = 0
    for(i <- 0 until (sizeT - p.length +1)) {
      val target = t.substring(i, i+(p.length))
      println("->" + target)
      if(target.toLong <= p.toLong){
        cnt += 1
      }
    }
    cnt
  }


//  println("->" + solution("3141592", "271"))
//  println("->" + solution("500220839878", "7"))
//  println("->" + solution("10203", "15"))
//  println("->" + solution("14", "14"))

  val a = "500220839878"
  a.sliding(5).foreach(println)


  val b = Seq.tabulate(5){i=>1}
  b.foreach(println)
}
