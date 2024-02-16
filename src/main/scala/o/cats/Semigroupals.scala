package o.cats

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
  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))
  val aTupledFuture = Semigroupal[Future].product(Future("the meaning of life"), Future(45)) // -> Future(("the meaning of life", 45))

  import cats.instances.list._
  val aTupledList = Semigroupal[List].product(List(1,2), List("a", "b"))  // --> List((1,a), (1,b), (2,a), (2,b))


  // ----- dependecy with Monad
  import cats.Monad
  def productWithMonads[F[_], A, B](fa: F[A], fb: F[B])(implicit monad: Monad[F]): F[(A, B)] =
    monad.flatMap(fa)(a => monad.map(fb)(b => (a, b)))

  import cats.syntax.functor._
  import cats.syntax.flatMap._
  def productWithMonads2[F[_], A, B](fa: F[A], fb: F[B])(implicit monad: Monad[F]): F[(A, B)] =
    for {
      a <- fa
      b <- fb
    } yield (a, b)


  trait CustomMonad[M[_]] {
    def pure[A](value: A): M[A]
    def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B]
    def map[A, B](ma: M[A])(f: A => B): M[B] =
      flatMap(ma)(x => pure(f(x)))
    // ----
    def product[A, B](fa: M[A], fb: M[B]): M[(A, B)] =
      flatMap(fa)(a => map(fb)(b => (a, b)))
  }

  // ----
  import cats.data.Validated
  type ErrorsOr[T] = Validated[List[String], T]
  val validatedSemigroupal = Semigroupal[ErrorsOr]

  val invalidsCombination = validatedSemigroupal.product(
    Validated.invalid(List("Error A", "Error B")),
    Validated.invalid(List("Error C"))
  )

  // --> Invalid(List(Error A, Error B, Error C))

  def main(args: Array[String]): Unit = {
    println(invalidsCombination)
  }

}
