

fun main() {
  class Solution {
    fun solution(): String {
      val str = readLine()!!
      val ascii = Array<Int>(26) { i -> 0 }

      for (i in 0 until str.length) {
        var idx: Int = if (str.get(i).toInt() - 65 < 26) {
          str.get(i).toInt() - 65
        } else {
          str.get(i).toInt() - 97
        }
        ascii[idx] = ascii[idx] + 1
      }

      var max: Int = -1;
      var answer = "0";

      for (i in 0 until ascii.size) {
        if (ascii[i] == 0) continue
        if (max < ascii[i]) {
          max = ascii[i]
          answer = (i + 65).toChar().toString()
        } else {
          if (max == ascii[i]) {
            answer = "?"
          }
        }
      }
      return answer
    }
  }
  println(
    Solution().solution()
  )
}