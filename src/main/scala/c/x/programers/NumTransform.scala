package c.x.programers

object NumTransform extends App {
  def solution(n: Int, control: String): Int = {
    val map = Map("w"-> 1, "s"-> -1, "d"-> 10, "a"-> -10)
    control.split("").foldLeft(n){(res, v) =>res + map(v) }
  }

  println(solution(0, "wsdawsdassw"))
}
