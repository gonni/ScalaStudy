package c.x.codingtest.mid

object BiggerIsGreater extends App {

  def biggerIsGreaterFailed(w: String): String = {
    val descOrder = w.toCharArray
    descOrder
      .sortWith(_<_)
      .permutations
      .toIndexedSeq
      .filter(a => a.mkString.compare(w) > 0)
      .take(1)
      .headOption
      .getOrElse(Array("no answer"))
      .mkString
  }

  def biggerIsGreater(w1: String): String = {
//    val string = StdIn.readLine().toBuffer
    val w = w1.toCharArray
    var i = w.size - 1

    while (i > 0 && w(i - 1) >= w(i)) i -= 1
    println(i)

    if (i <= 0) {
      "no answer"
    } else {
      var j = w.size - 1

      while (w(j) <= w(i - 1)) j -= 1
      println("j=" + j)
      println(w.mkString)

      val temp = w(i - 1)
      w(i - 1) = w(j)
      w(j) = temp
      println(w.mkString)

      println(i)
      w.patch(i, w.slice(i, w.size).reverse, w.size).mkString("")
    }
  }

  //abdc => acbd
  def biggerIsGreater1(w: String): String = {
    val arr = w.toCharArray
    var i = arr.length - 2
    while(arr(i) > arr(i+1)) {
      i -= 1
    }

    if(i < 0) {
      "no anwer"
    } else {
      w.patch(i, arr.slice(i, arr.length-1).sortWith(_<_), w.size).mkString
    }
  }

//  def swap(arr: Array[Char], i: Int, j: Int): Unit = {
//    val temp = arr(i)
//    arr(i) = arr(j)
//    arr(j) = temp
//  }

//  println(biggerIsGreater("abcd"))
//  println(biggerIsGreater("dkhc"))  // -> hcdk
//  println(biggerIsGreater("bbb"))  // -> answer


//  val input =
//    """
//      |lmno
//      |dcba
//      |dcbb
//      |abdc
//      |abcd
//      |fedcbabcd
//      |abdc
//      |""".stripMargin.trim.lines()//.forEach(println)
//
//  input.forEach(v => println(s"$v => ${biggerIsGreater(v)}"))

  println("abdc => " + biggerIsGreater("abdc"))
  println("abdc -> acbd")
}


