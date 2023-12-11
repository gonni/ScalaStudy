package c.x.sample

object MinMaxSum extends App {
  def miniMaxSum(arr: Array[Int]) = {
    // Write your code here
    val sortedList = arr.map(_.toLong).sortWith(_ > _)
    val sum = sortedList.sum
    println(sum - sortedList(0) + " " + (sum - sortedList(arr.length - 1)))
  }

  val sample = Array[Int] (256741038, 623958417, 467905213, 714532089, 938071625)
//  println(miniMaxSum(sample))
  miniMaxSum(sample)
}
