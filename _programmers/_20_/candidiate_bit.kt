// https://programmers.co.kr/learn/courses/30/lessons/42890?language=kotlin

class Solution {
  fun solution(relation: Array<Array<String>>): Int {
    var combinations = mutableListOf<Int>()
    var rows = relation.size
    var columns = relation[0].size

    for (i in 0..(1 shl columns)) {
      val keyMaps = HashMap<String, Int>()
      for (j in 0 until rows) {
        val records = mutableListOf<String>()
        for (k in 0 until columns) {
          if (i and (1 shl k) > 0) {
            records.add(relation[j][k])
          }
        }
        if (keyMaps.containsKey(records.joinToString("-"))) {
          keyMaps[records.joinToString("-")] = keyMaps[records.joinToString("-")]!! + 1
        } else {
          keyMaps[records.joinToString("-")] = 1
        }
      }
      val isUnique = (keyMaps.entries.size == rows)
      if (isUnique && isMinimal(combinations, i)) {
        combinations.add(i)
      }
    }
    return combinations.size
  }
  fun isMinimal (combinations: MutableList<Int>, now: Int): Boolean {
    for (i in 0 until combinations.size) {
      if ((combinations[i] and now) == combinations[i]) {
        return false
      }
    }
    return true
  }
}

fun main(args: Array<String>) {
  println(
  Solution()
    .solution(
      arrayOf<Array<String>>(
        arrayOf<String>("100","ryan","music","2"),
        arrayOf<String>("200","apeach","math","2"),
        arrayOf<String>("300","tube","computer","3"),
        arrayOf<String>("400","con","computer","4"),
        arrayOf<String>("500","muzi","music","3"),
        arrayOf<String>("600","apeach","music","2")
      )
    )
  )
}

