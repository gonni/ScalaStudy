package c.x.mapsort

import scala.collection
import scala.collection.immutable
import scala.collection.immutable.{HashMap, ListMap}

object MapSortMain extends App {

  def test1() = {
    val mp = immutable.HashMap[Int, String]()

    val mp1 = mp + (1 -> "A1", 20 -> "B2", 3 -> "C1")
    println(mp1)

    val cond1 = (mp1.toSeq.sortBy(_._1))

    val sortByKeyAsc = immutable.ListMap(mp1.toSeq.sortBy(_._1): _*)
    println(sortByKeyAsc)
    println(sortByKeyAsc.keys.head)

    val sortByValue = mp1.toSeq.sortWith(_._2 < _._2)
    println(sortByValue)

    val s1 = "A9"
    val s2 = "B1"

    println(s1.<(s2))

    val lmp = immutable.ListMap() ++ mp1
    println(lmp)

    val mp2 = mp1 + (1 -> "B1")
    println(mp2)

    val mp3 = HashMap("A" -> 5, "B" -> 32, "C" -> 2)
    val mp4 = mp3 + ("D" -> (mp3.getOrElse("D", 0) + 1))
    println(mp4)
  }

  println("Active System ..")

  val tmap = immutable.HashMap[Int, String]()
  val mp1 = tmap + (1 -> "A1", 20 -> "B2", 3 -> "C1")
  println("-->" + mp1)

  println("Result ->" + mp1.map(a => {a._2 + ":" + a._1}).mkString("|"))

  val reduced = mp1.reduce{(k1, k2) => {
    (k1._1 + k2._1, k1._2 + k2._2)
  }}

  println(reduced)
}
