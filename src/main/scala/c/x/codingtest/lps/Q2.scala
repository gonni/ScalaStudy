package c.x.codingtest.lps

object Q2 extends App {
  def solution(sentences: Vector[String], n: Int): Int = {
    val cntChars = sentences
      .flatMap(f => f.toCharArray)
      .filterNot(_ == ' ')
      .distinct

    val upperLetters = ('A' to 'Z').mkString

    def countUpper(sample: String, upperLetters: String = upperLetters) = {
      sample.map(ch => upperLetters.contains(ch)).filter(_ == true).length
    }

    val allLetters = ('a' to 'z').mkString + ('A' to 'Z').mkString
    val digits = ('0' to '9' ).mkString

//    val cntLetters = cntChars.filter(ch => allLetters.contains(ch)).size
//    val cntNum = cntChars.filter(ch => digits.contains(ch)).size

    if(cntChars.size > n) 0 // cannot score
    else if(cntChars.size == n) sentences.foldLeft(0){case(res, sen) => { // none shift
      res + sen.length
    }}
    else {  // shift
      sentences.foldLeft(0) {case(res, sen) => {
        res + sen.length + countUpper(sen)
      }}
    }
  }

  val sam = Vector("ABcD", "bdbc", "01abdd", "MusSeuk neWs")
  solution(sam, 7)

//  val upperLetters = ('A' to 'Z').mkString
//
//  def countUpper(sample: String, upperLetters: String = upperLetters) = {
//    sample.map(ch => upperLetters.contains(ch)).filter(_ == true).length
//  }
//
//  val a = Vector("mus seuK 1e", "MusEukE")
//
//  println(countUpper("mus sKUk 1e"))
//
//  solution(a, 7)

}
