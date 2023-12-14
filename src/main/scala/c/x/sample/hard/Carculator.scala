package c.x.sample.hard

import scala.collection.mutable

object Carculator extends App {

  def calc(postFixExpr: Array[String]) = {
    val valStack = mutable.Stack[Int]()

    for(token <- postFixExpr) {
      if("+-*/".contains(token)) {
        val b = valStack.pop()
        val a = valStack.pop()

        if("+" == token) {
          valStack.push(a + b)
        } else if("-" == token){
          valStack.push(a - b)
        } else if("*" == token) {
          valStack.push(a * b)
        } else if("/" == token) {
          valStack.push(a / b)
        }
      } else {
        valStack.push(token.toInt)
      }

      println(token + "===>" + valStack)
    }

    valStack

  }

  def getPostFixExpr(inFixExpr: String = "1+2*3") = {
//    val sample = "1+2*3"
    var resStack = Array[String]()
    val elemSeq = inFixExpr.trim
      .replace(" ", "")
      .map(_.toString)
    val operStack = new mutable.Stack[String]()
    // 1)
    for (ch <- elemSeq) {
      if (ch.toIntOption.isDefined) {
//        println("digit -> " + ch)
        resStack :+= ch
      } else if (ch == "(") {
//        println("open")
        resStack :+= ch
      } else if (ch == ")") {
//        println("close")
        resStack :+= ch
      } else if (ch == "+" || ch == "-" || ch == "*" || ch == "/") {
        pushOperator(ch, operStack)
      }
    }

    def priorityCompare(top: String, newone: String) = {
      val level1 = List("*", "/")
      val level2 = List("+", "-")

      if (level1.contains(top) && level2.contains(newone)) -1
      else if (level1.contains(newone) && level2.contains(top)) 1
      else 0
    }

    def pushOperator(ch: String, stack: mutable.Stack[String]): Unit = {
      if (stack.isEmpty) stack.push(ch)
      else {
        priorityCompare(stack.top, ch) match {
          case -1 =>
            val c0 = stack.pop()
//            println(c0)
            resStack :+= c0
            pushOperator(ch, stack)
          case 1 => // new one is higher
            stack.push(ch)
          case 0 =>
//            println(stack.pop())
            val c0 = stack.pop()
//            println(c0)
            resStack :+= c0
            pushOperator(ch, stack)
        }
      }
    }

    while (operStack.nonEmpty) {
      val c1 = operStack.pop()
//      println(c1)
      resStack :+= c1
    }

    resStack
  }





  val postRes = getPostFixExpr("1*2-8/4") // 12*34/-
  println("Post Res => " + postRes.mkString)

  calc(postRes).foreach(println)

}
