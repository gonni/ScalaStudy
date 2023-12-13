package c.x.codingtest

object StarTower extends App {
  def staircase(n: Int) = {
    (1 to n).foreach((v: Int) => {
      (1 to n - v).foreach(_ => print(" "))
      (1 to v).foreach(_ => print("*"))
      println
    })
  }

  def staircase2(n: Int) = {
    (1 to n).foreach(v => println(" "*(n-v) + "#"*v))
  }
//
//  println("*" * 6)
  staircase2(6)
}
