package o.cats

import cats.Monad

import scala.util.Try
object HandlingErrors {

  trait MyMonadError[M[_], E] extends Monad[M] {
    def raiseError[A](e: E): M[A]
  }

  import cats.MonadError
  import cats.instances.either._
  type ErrorOr[A] = Either[String, A]
  val monadErrorEither = MonadError[ErrorOr, String]
  val success = monadErrorEither.pure(32)
  val fealure = monadErrorEither.raiseError[Int]("something wrong")
  // recover
  val handlingErrors: ErrorOr[Int] = monadErrorEither.handleError(fealure) {
    case "Badness" => 44
    case _ => 89
  }
  // recoverWith
  val handledError2: ErrorOr[Int] = monadErrorEither.handleErrorWith(fealure) {
    case "Badness" => monadErrorEither.pure(44)
    case _ => Left("Something else")
  }
  // filter
  val filteredSuccess = monadErrorEither.ensure(success)("Number too small")(_  > 100)

  // Try and Future
  import cats.instances.try_._
  val exception = new RuntimeException("Really bad")
  val pureException: Try[Int] = MonadError[Try, Throwable].raiseError(exception)

  


}
