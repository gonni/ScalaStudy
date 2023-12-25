package c.x.codingtest.magic

object CardMerger {
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
