package c.x.codingtest.mid

object RunnerRanking extends App {
  def solution(players: Vector[String], callings: Vector[String]): Vector[String] = {
    var nameRank = players.zipWithIndex.toMap
    var calleeRanking: Int = -1
    var nameBacker: String = ""
    var fin = players
    for(callee <- callings) {
      calleeRanking = nameRank(callee)
      nameBacker = fin(calleeRanking-1)

      nameRank = nameRank + (callee -> (calleeRanking -1))
      nameRank = nameRank + (nameBacker -> (calleeRanking))

      fin = fin.updated(calleeRanking-1, callee)
      fin = fin.updated(calleeRanking, nameBacker)
    }
    fin
  }

  println(solution(Vector[String]("mumu", "soe", "poe", "kai", "mine"),
    Vector[String]("kai", "kai", "mine", "mine")).mkString(", "))
  //mumu, kai, mine, soe, poe
}
