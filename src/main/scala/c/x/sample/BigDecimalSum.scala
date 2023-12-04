package c.x.sample

import scala.util.Try

object BigDecimalSum extends App {

  val a = "111111111111111111119"
  val b = "91111111111111111111"


  def bigSum(a: String, b: String): String = {
    val lstA = a.toCharArray.toList.map(ch => ch.toString).reverse
    val lstB = b.toCharArray.toList.map(ch => ch.toString).reverse

    val midSum = lstA.zipWithIndex.map(ai => {
      val aiNum = ai._1.toInt
      val aiIdx = ai._2
      println(aiNum + ", " + aiIdx)
      val biNum = Try[Int](lstB(aiIdx).toInt).getOrElse(0)
      aiNum + biNum
    })

    var higherNum: Int = 0
    midSum.map(v => {
      v compare 10 match {
        case x if 0 to 1 contains(x) =>
          higherNum = 1
          (v - 10)
        case -1 =>
          val ret = v + higherNum
          higherNum = 0
          ret
      }

//      if(v > 9) {
//        higherNum = 1
//        v - 10
//      } else {
//        val ret = v + higherNum
//        higherNum = 0
//        ret
//      }
    }).reverse.mkString
  }


  println("result =>" + bigSum(a, b))
}
