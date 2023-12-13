package c.x.codingtest

object BirthdayCandles extends App {
  def birthdayCakeCandles(candles: Array[Int]): Int = {
    candles.count(p => p == candles.max)
  }

  def birthdayCakeCandles2(candles: Array[Int]): Int = {
    candles.count(p => p == candles.max)
  }

  println(birthdayCakeCandles(Array[Int](3, 2, 1, 3)))
}
