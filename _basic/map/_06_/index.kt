import java.util.ArrayList;

fun main(args: Array<String>) {
  class Solution {
    fun solution(stats: IntArray): Int {
      val teams: ArrayList<Int> = arrayListOf<Int>()
      for (i: Int in stats) {
        if (teams.size == 0) {
          teams.add(i);
        } else {
          var joined: Boolean = false
          for (j in 0 until teams.size) {
            if (i > teams.get(j)) {
              teams.set(j, i)
              joined = true
              break
            }
          }
          if (!joined) {
            teams.add(i)
          }
        }
      }
      return teams.size
    }
  }

  println(
    Solution().solution(
      intArrayOf(
        6,
        2,
        3,
        4,
        1,
        5
        )
    )
  );
}