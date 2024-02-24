package o.cats

import cats.Functor
import cats.implicits.catsSyntaxApplicativeId

object Applicatives {


  // Appicatives = Functors + the pure method
  import cats.Applicative
  import cats.instances.list._
  val listApplicative = Applicative[List]
  val aList = listApplicative.pure(2) // List(2)

  import cats.instances.option._
  val optionApplicative = Applicative[Option]
  val anOption = optionApplicative.pure(2)  // Some(2)

  // pure extension method
  import cats.syntax.applicative._
  val aSweetList = 2.pure[List]
  val aSweetOption = 2.pure[Option]

  // Monads extends Applicatives
  // Applicatives extends Functors
  import cats.data.Validated
  type ErrorOr[T] = Validated[List[String], T]
  val aValidValue = Validated.valid(22) // pure
  val aModifiedValidate: ErrorOr[Int] = aValidValue.map(_ + 1)  // map

  // ---
//  def ap[W[_], A, B](wf: W[A => B])(wa: W[A]): W[B] = ???
  def productWithApplicatives[W[_], A, B](wa: W[A], wb: W[B])(implicit applicative: Applicative[W]): W[(A, B)] = {
    val fuctionWrapper: W[B => (A, B)] = applicative.map(wa)(a => (b: B) => (a, b))
    applicative.ap(fuctionWrapper)(wb)
  }

  def productWithApplicatives[W[_], A, B](wa: W[A], wb: W[B])(implicit applicative: Applicative[W]): W[(A, B)] = {
    val functionWrappper: W[B => (A, B)] = applicative.map(wa)(a => (b: B) => (a, b))
    applicative.ap(functionWrappper)(wb)
  }

  // Applicatives have this ap[W[_], B, T](wf: W[B=>T](wa: W[B]): W[T]
  // ==> Applicative implements Semigroupal


  // Apply
  import cats.Semigroupal
  trait MyApply[W[_]] extends Functor[W] with Semigroupal[W] {
    override def product[A, B](fa: W[A], fb: W[B]): W[(A, B)] = {
      val fuctionWrapper: W[B => (A, B)] = map(fa)(a => (b: B) => (a, b))
      ap(fuctionWrapper)(fb)
    }
    def mapN[A, B, C](tupled: (W[A], W[B]))(f: (A, B) => C): W[C] = {
      val tupleWrapper = product(tupled._1, tupled._2)
      map(tupleWrapper) {
        case (a, b) => f(a, b)
      }
    }

    def ap[W[_], B, T](wf: W[B=>T])(wa: W[B]): W[T]
  }

  trait MyApplicative[W[_]] extends MyApply[W] {
    def pure[A](x: A): W[A]
    def map[A, B](fa: W[A])(f: A=>B): W[B]
  }

  import cats.Apply
  import cats.instances.option._

  val applyOption = Apply[Option]
  val funcApp = applyOption.ap(Some((x:Int) => x + 1))(Some(2)) // Some(3)

  import cats.syntax.apply._
  val tupleOfOptions = (Option(1), Option(2), Option(3))
  val optionOfTuples = tupleOfOptions.tupled
  val sumOption = tupleOfOptions.mapN(_ + _ + _)



  def main(args: Array[String]): Unit = {

    val x = productWithApplicatives[Option, Int, String](Option(1), None)
    println("Applicative Result =>" + x)

    val y = productWithApplicatives[List, Int, String](List(1,2), List("A", "B"))
    println("Ap Result =>" + y)
    
  }
}
