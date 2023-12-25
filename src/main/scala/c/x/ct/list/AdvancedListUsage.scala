package c.x.ct.list

object AdvancedListUsage extends App {
//  val skip = "abcde"
//  val avail = ('a' to 'z').filterNot(c => skip.contains(c))
//
//
//  val index = 5
//  avail
//
//  val indexed = avail.drop(5) ++ avail.take(5)
//  println("->" + avail.mkString)
//  println("=>" + indexed.mkString)
//
//  val map = avail.zip(indexed).toMap
//  println(map('z'))


  val sample = Vector("OXXO", "XSXO", "XXXX")


  def startOf(park: Seq[String], acc: (Int, Int) = (0, 0)): (Int, Int) = {
    park match {
      case head :: tail if head.contains("S") => (acc._1, head.indexOf("S"))
      case _    :: tail => startOf(tail, (acc._1 + 1, acc._2))
    }
  }

  println(startOf(sample.toList))

  // ---

  val routes = Vector("E 2", "S 3", "W 1")
  val result = routes.foldLeft((0, 0)) {
    case (acc, route) => {
      val (x, y) = acc
      println(route)
      (1,2)
    }
  }

  println("Result -> " + result)


  val t2s = List[(Int,Int)]((1,2), (3,4), (5,6))
  println("LeftFolded ->" + t2s.foldLeft((0,0)){case(cRes, t2) =>
    (cRes._1 + t2._1, cRes._2 + t2._2)
  })

  println(sample.slice(1,3).map(_(1)).mkString)

}

class CardMerger {
  object Solution {
    def solution(cards1: Vector[String], cards2: Vector[String], goal: Vector[String]): String = {
      def loop(cards1: Seq[String], cards2: Seq[String], goal: Vector[String]): Boolean = {
        if (goal.isEmpty) true
        else {
          (cards1, cards2) match {
            case (h :: t, _) if (h == goal.head) => loop(t, cards2, goal.tail)
            case (_, h :: t) if (h == goal.head) => loop(cards1, t, goal.tail)
            case _ => false
          }
        }
      }

      if (loop(cards1.toList, cards2.toList, goal)) "Yes" else "No"
    }
  }
}
