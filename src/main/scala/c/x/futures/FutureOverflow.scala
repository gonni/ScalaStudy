package c.x.futures

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
object FutureOverflow extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  println("Active System ..")

  val ranges = 1 to 100000

  val x = for {
    i <- Future.sequence(ranges.map(r => Future{
      println("Exec => " + r)
              Thread.sleep((Math.random() * 10).toLong)
              1
            }.recover{
      case e: Exception =>
        println("Error" + e.getMessage)
        0
    }))
  } yield i

  val result = Await.result(x, Duration.Inf)
  println("result sum => " + result.foldLeft(0)(_ + _))

}
