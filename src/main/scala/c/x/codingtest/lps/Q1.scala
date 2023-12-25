package c.x.codingtest.lps
import scala.util.matching.Regex
object Q1 extends App {
  val reg = new Regex("^[a-zA-Z]*$")
  def solution(logs: Vector[String]): Int = {
    logs.map(log=>isValid(log)).filter(_ == false).length
  }

  val keys = Seq[String]("team_name", "application_name", "error_level", "message")

  def isValid(log: String): Boolean = {
    if(log.length > 100) return false
    val cmdAllCheck = keys.forall(k => keys.contains(k))
    if(!cmdAllCheck) return false

    val relog = log.replaceAll(" : ", ":")
    val kvs = relog.split(" ")

    if(kvs.size == 4) {
      val result = kvs.map(kv => {
        if(kv.contains(":")) {
          val tk = kv.split(":")
          val k = tk(0)
          val v = tk(1)
          //println(k + " " + v)
          if(v.length > 0 ) {
            val keyResult = if (k == "team_name" || k == "application_name" || k == "error_level" || k == "message") 0 else -1
            val valResult = if (reg.matches(v)) 0 else -1
            keyResult + valResult
          } else {
            -1
          }
        } else {
          -1
        }
      }).min
      if(result == 0) true else false
    } else {
      false
    }
  }
//"team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"]
//  val s = Vector("team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError")
  val s = Vector("team_name : db application_name : dbtest error_level : info message : test",
    "team_name : test application_name : I DONT CARE error_level : error message : x",
    "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever",
    "team_name : oberervability application_name : LogViewer error_level : error")
  println(solution(s))
//  val a = Vector("team_name : db application_name : dbtest team_name : error_leve: info message : test")
//  //  solution(a)
//
//  val s = "team_name : db application_name : dbtest error_leve : info message : test"
//
//  val ss = "team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange"
//  val ss = "team_name : db application_name : dbtest error_level : info message : test"
  val ss = "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever" // true
//  val ss = "team_name : test application_name : I DONT CARE error_level : error message : x" // f
//  val ss = "team_name : db application_name : dbtest error_level : info message : test"  // true

  println("result =>" + isValid(ss))



//  println(reg.matches("abcD1e"))
//  println(reg.matches("abcD1e"))


//  s.replaceAll(" : ", ":").split(" ").foreach(println)
//  println()

}
