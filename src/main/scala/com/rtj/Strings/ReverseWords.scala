package com.rtj.Strings

object ReverseWords {

  def reverseWords(string: String): String = {
    string.split(" ").reverse.mkString(" ")
  }


  def main(args: Array[String]): Unit = {
    println(reverseWords("Alice loves Scala"))
  }
}
