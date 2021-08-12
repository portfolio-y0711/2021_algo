
fun main(args: Array<String>) {
  class Solution {
    fun solution(c: Int, _houses: IntArray) {
      val houses = _houses.sorted().toIntArray()

      var left = 0
      var right = houses.max()!!
      var mid = (left + right) / 2
      var prev: Int = houses.get(0)
      var wifi: Int

      var counter = 0
      while (left <= right) {
        wifi = 1
        counter = counter + 1
        if (counter > 1) break

        for (i in 1 until houses.size) {
          if (prev + mid <= houses.get(i)) {
            wifi = wifi + 1
          }
        }

        if (wifi >= c) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      }
      println(right)
    }
  }

  Solution()
    .solution(
      5,
      intArrayOf(
        1,
        2,
        8,
        4,
        9
      )
    );
}