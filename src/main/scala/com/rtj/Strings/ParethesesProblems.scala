package com.rtj.Strings

import scala.annotation.tailrec

object ParethesesProblems extends App {

  def hasValidParenthese(string: String) : Boolean = {
    @tailrec
    def checkParRec(remains: String, opened: Int): Boolean = {
      if(opened == 0 && remains.length == 0) true
      else if(opened < 0) false
      else if(remains.head == '(') checkParRec(remains.tail, opened + 1)
      else checkParRec(remains.tail, opened - 1)
    }
    checkParRec(string, 0)
  }

//  println("=>" + hasValidParenthese("()()"))
//  println("=>" + hasValidParenthese("(())"))
//  println("=>" + hasValidParenthese(""))
//  println("=>" + hasValidParenthese(")("))

  def generateAllValidParenthses(n: Int): List[String] = {
    @tailrec
    def genParensTailrec(nRemainTurn: Int, currentStrings: Set[String]): Set[String] = {
      println(s"Turn $nRemainTurn/$n with $currentStrings")

      if(nRemainTurn == 0) currentStrings
      else {
        val newString = for {
          string <- currentStrings
          index <- 0 until string.length
        } yield {
          val (b, a) = string.splitAt(index)
          println(s"--> $b|$a")

          s"$b()$a"
        }
        genParensTailrec(nRemainTurn - 1, newString)
      }
    }
    assert(n >= 0)

    if(n == 0) List()
    genParensTailrec(n - 1, Set("()")).toList
  }

  List(1,2,3).foreach(n => println(n + "=>" + generateAllValidParenthses(n)))
}
