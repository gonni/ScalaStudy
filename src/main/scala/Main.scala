object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val res = for {
      target <- Set("A", "B", "C")
      idx <- 1 to 3
    } yield (target, idx)

    res.toList.foreach(println)
  }
}