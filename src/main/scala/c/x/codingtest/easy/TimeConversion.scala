package c.x.codingtest.easy

object TimeConversion extends App {

  def timeConversion(s: String): String = {
    // Write your code here
    val dayNight = s.substring(s.length -2)
    val hhmmss = s.substring(0, s.length-2)

    val arrHms = hhmmss.split("\\:")
    val head = if(dayNight == "PM") {if(arrHms(0).toInt < 12) arrHms(0).toInt + 12 else "12"}
    else if(dayNight == "AM") if(arrHms(0).toInt == 12) "00" else arrHms(0)

    (Seq(head) :+ arrHms(1) :+ arrHms(2)).mkString(":")
  }

  println(timeConversion("12:40:22AM"))
}
