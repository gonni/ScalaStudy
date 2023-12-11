package c.x.sample
import scala.collection.Searching.{Found, InsertionPoint}
import scala.collection.mutable._

object ClimbingTheLeaderboard extends App {

  def climbingLeaderboard0(ranked: Array[Int], player: Array[Int]): Array[Int] = {

//    val board = ranked.distinct
//
//    player.map(p => {
//      val res = insertArr(arrTemp, p)
//      arrTemp = res._1
//      res._2
//    })
    ???
  }
  def climbingLeaderboard(
                           ranked: Array[Int],
                           player: Array[Int]
                         ): Array[Int] = {
    val ranking = Int.MaxValue +: ranked.distinctBy(identity) :+ -1;

    player.foldLeft(Array.empty[Int]) { case (acc, p) =>
      ranking.search(p)(Ordering.Int.reverse) match {
        case Found(v) => acc :+ v
        case InsertionPoint(v) => acc :+ v
      }
    }
  }

//  def insertArr(arr: Array[Int], value: Int) = {
//    val targetIndex = arr.indexWhere(_ < value) match {
//      case idx if idx == -1 => arr.length
//      case idx => idx
//    }
//    val sep = arr.splitAt(targetIndex)
//    val arrRes = if(targetIndex == -1) arr :+ value else sep._1 :+ value :++ sep._2
//    val index = (arrRes.toSet.toList.sortWith(_ > _).indexWhere(_ < value)) match {
//      case idx if idx == -1 => arrRes.toSet.size
//      case idx => idx
//    }
//    (arrRes, index)
//  }

  def insertArr(arr: Array[Int], value: Int) = {




  }

  def insertArr0(arr: Array[Int], value: Int) = {

    val sortedSetList = arr.toSet.toArray.sortWith(_ > _)
    val idx = sortedSetList.indexWhere(_ <= value)
    val index = if(idx == -1) sortedSetList.length else idx

    val split =  sortedSetList.splitAt(index)
    val added = if(!sortedSetList.contains(value)) split._1 :+ value :++ split._2 else sortedSetList

    (added, index + 1)
//    val targetIndex = magic(arr.indexWhere(_ < value), arr.length)
//    val sep = arr.splitAt(targetIndex)
//    val arrRes = if(targetIndex == -1) arr :+ value else sep._1 :+ value :++ sep._2
//    val setRes = arrRes.toSet
//    val index = magic(setRes.toList.sortWith(_ > _).indexWhere(_ < value), setRes.size)
//    (arrRes, index)
  }

//  def magic(value: Int, length: Int) = value match {
//    case idx if idx == -1 => length
//    case idx => idx
//  }

//  def insert(list: List[Any], i: Int, value: Any): List[Any] = list match {
//    case head :: tail if i > 0 => head :: insert(tail, i-1, value)
//    case _ => value :: list
//  }


  val sample = Array[Int](100,100,50,40,40,20,10)
//  println("=>" + insert(sample, 2, 3))

//  climbingLeaderboard(sample, Array[Int](5, 25, 50, 120)).foreach(println)

  println(sample.distinct.search(50)(Ordering.Int.reverse))
}
