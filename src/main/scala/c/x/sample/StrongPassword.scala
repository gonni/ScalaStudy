package c.x.sample

import scala.annotation.tailrec
import scala.collection.immutable
import scala.util.control.Breaks.break

object StrongPassword {

  def minimumNumber(n: Int, password: String): Int = {
    // Return the minimum number of characters to make the password strong
    val strTypes = immutable.Seq((0 to 9).mkString, ('a' to 'z').mkString, ('A' to 'Z').mkString, "!@#$%^&*()-+")

    @tailrec
    def getTypeNum(ch: Char, typeIdx: Int): Int = {
      if(typeIdx > strTypes.length - 1) -1
      if(strTypes(typeIdx).contains(ch.toString)) typeIdx
      else getTypeNum(ch, typeIdx + 1)
    }

    val cntNeededTypes = strTypes.length - password.toCharArray.toSet[Char].map(ch => {
      getTypeNum(ch, 0)
    }).size

    if(cntNeededTypes > 6 - n) cntNeededTypes else 6 - n
  }

  def main(args: Array[String]): Unit = {
    println(minimumNumber(5, "2bb#A"))
    println(minimumNumber(5, "2bbbb"))
    println(minimumNumber(3, "Ab1"))
  }
}
