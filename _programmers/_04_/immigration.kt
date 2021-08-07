// https://programmers.co.kr/learn/courses/30/lessons/43238

// 


class Solution04 {
  fun solution(n: Int, times: IntArray): Long {
    var left = 1L
    var right = times.max()!! * n.toLong()
    var answer: Long = 0
    var mid: Long
    var total: Long

    while (left < right) {
      mid = (left + right) / 2
      total = times.fold(0L) { 
        _total, t -> 
        _total + mid / t
      }
      if (total >= n) {
        right = mid
      } else {
        left = mid + 1
      }
      answer = left.toLong()
    }
    return answer
  }
}

fun main(args: Array<String>) {
  println(
  Solution04()
    .solution(
      6,
      intArrayOf(7, 10)	
    ) 
  )
}
