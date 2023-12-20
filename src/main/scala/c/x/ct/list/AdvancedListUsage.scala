package c.x.ct.list

object AdvancedListUsage extends App {
  val skip = "abcde"
  val avail = ('a' to 'z').filterNot(c => skip.contains(c))


  val index = 5
  avail

  val indexed = avail.drop(5) ++ avail.take(5)
  println("->" + avail.mkString)
  println("=>" + indexed.mkString)

  val map = avail.zip(indexed).toMap
  println(map('z'))
}
