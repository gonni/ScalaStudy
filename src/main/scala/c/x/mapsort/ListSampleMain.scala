package c.x.mapsort

import scala.::
import scala.collection.immutable

object ListSampleMain extends App {

  val l1 = immutable.Seq("A", "B", "C")
  val l2 = "D" +: l1 :+ "E"
  println(l2)

  val l3 = l2.sorted
  println(l3)

  val l4 = l2.sortWith((a, b) => a > b)
  println(l4)
}
