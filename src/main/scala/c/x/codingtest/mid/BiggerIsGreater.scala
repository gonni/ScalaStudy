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

  def biggerIsGreater(w: String): String = {
    def swap(arr: Array[Char], i: Int, j: Int): Unit = {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    val chars = w.toCharArray
    val charSortedIncr = chars.sortWith(_<_)//.toIndexedSeq
    var i = chars.length - 2
    while(i >= 0 && chars(i) >= chars(i+1)) {
      i -= 1
    }

    if(i > 0) {
      swap(chars, i, i+1)
      chars.mkString
    } else if (i == -1) {
      "no answer"
    } else if(i == 0) {
      val h1 = charSortedIncr(charSortedIncr.indexOf(chars(0)) + 1)
      val newOne = h1 +: charSortedIncr.filterNot(_ == h1)//.sortWith(_<_)
      newOne.mkString
    } else {
      "ERROR"
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


  val input =
    """
      |lmno
      |dcba
      |dcbb
      |abdc
      |abcd
      |fedcbabcd
      |abdc
      |""".stripMargin.trim.lines()//.forEach(println)

  input.forEach(v => println(s"$v => ${biggerIsGreater(v)}"))

  println("abdc -> acbd")
}


