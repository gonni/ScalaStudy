package c.x.basic

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext._
import scala.concurrent.duration.Duration
object FutureMonadTest extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  val res = (for {
    _ <- Future(println("A"))
    _ <- Future(println("B"))
    _ <- Future.failed(new Exception("Exception Occured .."))
    _ <- Future(println("C"))
  } yield (1)).recover{
    case e: Exception =>
      e.printStackTrace()
      0
  }

  println("result => " + Await.result(res, Duration.Inf))

//  println("result => " + res)
}
