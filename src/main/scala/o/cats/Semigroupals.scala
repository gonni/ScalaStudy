package o.cats

import zio.prelude.classic.Applicative

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}

object Semigroupals {

  trait MySemigroupal[F[_]] {
    def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
  }

  import cats.Semigroupal
  import cats.instances.option._

  val optionSemig = Semigroupal[Option]
  val aTupledOption = optionSemig.product(Some(123), Some("a string"))
  val NoneTupled = optionSemig.product(Some(123), None)

  import cats.instances.future._

  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(0))
  val aTupledFuture = Semigroupal[Future].product(Future("the meaning of life"), Future(45))

  import cats.instances.list._
  val aTupledList = Semigroupal[List].product(List(1,2), List("a", "b"))


  // -----




  def main(args: Array[String]): Unit = {

  }

}
