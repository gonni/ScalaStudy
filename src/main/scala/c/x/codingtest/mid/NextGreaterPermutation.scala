package c.x.codingtest.mid

object NextGreaterPermutation {
  def main(args: Array[String]): Unit = {
//    val input = "dcba"
    val input = "dkhc"  // abcd  --> hcdk |  k>h>d>c
    val result = findNextGreaterPermutation(input)
    println(s"The next greater permutation: $result")
  }

  def findNextGreaterPermutation(input: String): String = {
    val chars = input.toCharArray
    val n = chars.length

    // 1. 오른쪽에서 왼쪽으로 이동하면서 첫 번째 감소하는 인덱스(i) 찾기
    var i = n - 2
    while (i >= 0 && chars(i) >= chars(i + 1)) {
      i -= 1
    }
    println(s"1. i = $i")
    // 이미 마지막 순열인 경우
    if (i == -1) {
      return "No greater permutation found"
    }

    // 2. i 이후에서 input(i)보다 큰 첫 번째 문자 찾기, i = 2, 4 = 4
    var j = n - 1
    while (chars(j) <= chars(i)) {
      j -= 1
    }

    println(s"2. i : j = $i : $j")

    // 3. i와 j 위치의 문자 교환 j=3, i=2
    swap(chars, i, j)
    println("=>" + chars.mkString)

    // 4. i 이후 문자열 뒷부분을 뒤집기
    reverse(chars, i + 1, n - 1)  // 3, 3
    println("==>" + chars.mkString)

    new String(chars)
  }

  private def swap(chars: Array[Char], i: Int, j: Int): Unit = {
    val temp = chars(i)
    chars(i) = chars(j)
    chars(j) = temp
  }

  private def reverse(chars: Array[Char], start: Int, end: Int): Unit = {
    var i = start
    var j = end
    while (i < j) {
      swap(chars, i, j)
      i += 1
      j -= 1
    }
  }
}
