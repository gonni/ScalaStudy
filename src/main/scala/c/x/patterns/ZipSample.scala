package c.x.patterns
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object ZipSample extends App {

  val aF = Future{
    Thread.sleep(10000L)
    println("Thread a Fin")
    1
  }

  val bF = Future {
    Thread.sleep(5000L)
    println("Thread b Fin")
    2
  }

  val result = for {
    av <- aF
    bv <- bF
  } yield (av + bv)

  val st = System.currentTimeMillis()
  val aaa = Await.result(result, Duration.Inf)
  println("result :" + aaa + "for " + (System.currentTimeMillis() - st))


  val cF = aF.zip(bF)
  val a2 = Await.result(cF, Duration.Inf)
  val xt = System.currentTimeMillis()

  println("result with zip:" + cF + " for " + (System.currentTimeMillis() - xt))

}
