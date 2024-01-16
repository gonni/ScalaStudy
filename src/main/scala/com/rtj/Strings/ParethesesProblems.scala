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

  }

}
