package c.x.codingtest.easy


object WalkDogPark extends App {

//  def solution(park: Vector[String], routes: Vector[String]): Vector[Int] = {
//    val wMap = park.toArray.map(row => row.toCharArray)
//
//    val start = (for {
//      r <- wMap.zipWithIndex
//      c <- r._1.zipWithIndex if c._1 == 'S'
//    } yield (r._2, c._2)).head
//
//    val cmd = routes.toArray.map(a => {
//      val ch = a.split(" ")
//      (ch(0), ch(1).toInt)
//    })
//
//    var cur = start
//
//    def containsX(i: Int, j: Int, fixedY: Int): Boolean = {
//      for(x <- i to j) {
//        if(wMap(fixedY)(x) == 'X') return false
//      }
//      true
//    }
//    def containsY(i: Int, j: Int, fixedX: Int): Boolean = {
//      for(x <- i to j) {
//        if(wMap(x)(fixedX) == 'X') return false
//      }
//      true
//    }
//    println("-----")
//    for ((d, i) <- cmd) {
//      print(s"$cur --> $d:$i")
//      if (d == "W") {
//        if(cur._2 - i >= 0
//          && containsX(cur._2 - i, cur._2, cur._1)) cur = (cur._1, cur._2 - i)
//      } else if (d == "E") {
//        if(cur._2 + i < wMap.head.length
//          && containsX(cur._2, (cur._2 + i), cur._1)) cur = (cur._1, cur._2 + i)
//      } else if (d == "N") {
//        if(cur._1 - i >= 0
//          && containsY(cur._1 - i, cur._1, cur._2)) cur = (cur._1 -i, cur._2)
//      } else if (d == "S") {
//        if(cur._1 + i < wMap.length
//          && containsY(cur._1, cur._1 + i, cur._2)) cur = (cur._1 + i, cur._2)
//      }
//
//      println(s" --> $cur")
//    }
//
//    Vector[Int](cur._1, cur._2)
//  }


  def solution(park: Vector[String], routes: Vector[String]): Vector[Int] = {
    val h = park.size
    val w = park.head.size

    def startOf(park: Seq[String], acc: (Int, Int) = (0, 0)): (Int, Int) = {
      park match {
        case head :: tail if head.contains("S") => (acc._1, head.indexOf("S"))
        case _    :: tail => startOf(tail, (acc._1 + 1, acc._2))
      }
    }

    def execute(route: String, x: Int, y: Int): (Int, Int) = {
      val op = route.split(" ").head
      val n  = route.split(" ").last.toInt

      op match {
        case "N" if y - n >= 0 && park.slice(y - n, y).map(_(x)).mkString.forall(_ != 'X') =>
          (y - n, x)
        case "S" if y + n <  h && park.slice(y + 1, y + n + 1).map(_(x)).mkString.forall(_ != 'X') =>
          (y + n, x)
        case "W" if x - n >= 0 && (park(y).substring(x - n, x).forall(_ != 'X')) =>
          (y, x - n)
        case "E" if x + n <  w && (park(y).substring(x + 1, x + n + 1).forall(_ != 'X')) =>
          (y, x + n)
        case _ => (y, x)
      }
    }

    val (y, x) = routes.foldLeft(startOf(park.toList)) { case (acc, route) =>
      val (y, x) = acc

      execute(route, x, y)
    }

    Vector(y, x)
  }


  solution(Vector("SOO", "OOO", "OOO"), Vector("E 2", "S 2", "W 1")).foreach(println)
  solution(Vector("SOO", "OXX", "OOO"), Vector("E 2", "S 2", "W 1")).foreach(println)
  solution(Vector("OSO", "OOO", "OXO", "OOO"), Vector("E 2", "S 3", "W 1")).foreach(println)
  solution(Vector("OXXO", "XSXO", "XXXX"), Vector("E 1", "S 1")).foreach(println)
//  println("++++++++")
//  Array(0,1,2,3,4,5).slice(1,2).foreach(println)
  //  "W 1".split(" ").foreach(println)

}
