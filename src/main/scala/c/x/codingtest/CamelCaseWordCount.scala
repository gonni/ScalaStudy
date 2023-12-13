package c.x.codingtest

object CamelCaseWordCount {

  def camelcase(s: String): Int = {
    // Write your code here
    s.count(c => {
      c match {
        case c if ('A' to 'Z').contains(c) => true
        case _ => false
      }
    }) + 1
  }

  def main(args: Array[String]): Unit = {
    println("=>" + camelcase("myNameIsYoungGonKim"))
  }
}
