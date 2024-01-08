package c.x.basic

object ListMagic extends App {
  val aList = List(1,2,3)
  val apppeded = 0 :: aList
  val aBigList = 0 :: 1 :: 2 :: List(3,4)
  println(aBigList.mkString("/"))


  
}
