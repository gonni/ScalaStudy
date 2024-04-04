package c.x.playground

object Sample extends App {
  println(Math.round(((44.0 / 76.0) * 100.0) / 100.0))

  println(Math.round(((44.0 / 76.0) * 100.0) / 100.0))

  val number = BigDecimal(44.0 / 76.0).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  println("->" + number)

}
