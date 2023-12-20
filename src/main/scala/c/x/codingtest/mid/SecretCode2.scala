package c.x.codingtest.mid

object SecretCode2 extends App {

  def solution(s: String, skip: String, index: Int): String = {
    //    val removed = skip.toCharArray
    //
    //    val a2z = ('a' to 'z').toVector
    //    val removedA2z = a2z.flatMap(c => {
    //      if(removed.contains(c))
    //        Vector()
    //      else
    //        Vector(c)
    //    })
    //
    //    s.toCharArray.map(c => {
    //      val reIdx = removedA2z.indexOf(c) + index
    //      removedA2z(reIdx%removedA2z.length)
    //    }).mkString

    val avail = ('a' to 'z').filterNot(c => skip.contains(c))
    val y = avail.drop(index % avail.size) ++ avail.take(index % avail.size)

    avail.drop(5)

    val remap = avail.zip(avail.drop(index % avail.size) ++ avail.take(index % avail.size)).toMap
    println(remap.mkString(","))

    s.map { c => remap(c) }
  }
  println(solution("aukks", "wbqd", 5))

}
