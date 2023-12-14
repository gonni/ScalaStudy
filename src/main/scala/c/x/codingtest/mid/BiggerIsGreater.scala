package c.x.codingtest.mid

object BiggerIsGreater extends App {
  def biggerIsGreater(w: String): String = {
    val descOrder = w.toCharArray.sortWith(_<_)
    descOrder.zipWithIndex.foreach(println)

    println("------------")

//    w.toCharArray.map(c => descOrder.indexOf(c)).foreach(println)



    ""
  }

//  biggerIsGreater("dkhc")

//  createAllComposition(Array[Int](4,3,2,1))
  val sample = Array[Int](1,2,3,4)
  var count = 0

  def permutation(arr: Array[Int], s: Int, r: Int): Unit = {
    println(arr.mkString("|"))
    if(s == r) {
      count += 1
    }

    for(i <- s until arr.length)  {
      val temp = arr(s)
      arr(s) = arr(i)
      arr(i) = temp

      permutation(arr, s+1, r)

      val temp1 = arr(s)
      arr(s) = arr(i)
      arr(i) = temp1
    }
  }


  permutation(sample, 0, 2)

}


