// https://programmers.co.kr/learn/courses/30/lessons/72411?language=kotlin

// 메뉴 주문을 부호화한 문자열이 담긴 리스트와 코스 요리의 개수를 담은 숫자 리스트를 인자로 입력 받음
// 주문 리스트를 iter 순회하되, 각 문자열을 문자 배열 리스트로 변환한 뒤 문자 배열로 가능한 모든 조합을 구함
// 각 조합을 나타내는 문자열 리스트에 join 연산을 적용하여 주문 가능 메뉴 들이 담긴 문자열을 구성함
// 주문 가능 메뉴들이 담긴 문자열을 키로 사용하여 맵에 해당 키가 있는지 확인함
// 키가 없으면 1을 할당하고
// 키가 있으면 기존 값에 1을 가산함
// 맵을 리스트로 변환하고, 리스트를 순회하며 최대값을 구함
// 다시 한번 변환된 리스트를 순회하며 최대값과 같은 엔트리를 찾아 결과 배열에 담음


fun comb (arr: CharArray, selectNumber: Int): ArrayList<String> {
  val resultlist = ArrayList<String>()
  fun DFS(_L: Int, _start: Int, _result: ArrayList<Char>) {
    val result = ArrayList<Char>()
    result.addAll(_result)
    if (_L == selectNumber) {
        // println(result.joinToString(""))
        resultlist.add(result.joinToString("")) 
    } else {
      for (i in _start..arr.size - 1) {
        // println(selectNumber)
        result.add(arr[i])

        DFS(_L + 1, i + 1, result)
        result.removeAt(result.size - 1)
      }
    }
  }
  DFS(0, 0, ArrayList<Char>())
  return resultlist
}

class Solution10 {
  fun solution(orders: Array<String>, course: IntArray): Array<String> {
      val result = mutableListOf<String>()
      for (n in course) {
        val combinations = orders.fold(HashMap<String, Int>()) { 
            menuMap, order -> 
            val _list = order.toCharArray()
            _list.sort()
            comb(_list, n).forEach {
              if (!menuMap.containsKey(it)) {
                menuMap.put(it, 1)
              } else {
                menuMap.put(it, menuMap.get(it)!! + 1)
              }
            }
            menuMap
        }
        val list = combinations.entries
        // println(list)
        val maxCounter = list.fold(0) {
          _max, curr ->
          if (_max < curr.value) {
            curr.value
          } else {
            _max
          }
        }
        // println(maxCounter)
        list.forEach {
          // println(it)
          if (it.value == maxCounter && maxCounter > 1) result.add(it.key)
        }
          
      }
      result.sort()
      return result.toTypedArray()
  }
}

fun main(args: Array<String>) {
  val result = Solution10()  
    .solution(
      // arrayOf(
        // "ABCFG", 
        // "AC",
        // "CDE",
        // "ACDE", 
        // "BCFG", 
        // "ACDEH"
      // ),	
      // intArrayOf(2,3,4)
      arrayOf(
        "XYZ", "XWY", "WXA"
      ),	
      intArrayOf(2,3,4)
    )
  result.forEach { 
    println(it)
   }
}


// val results = arr.foldIndexed(ArrayList<Char>()) { 
//   idx, acc, selected -> 
//   println(idx)
//   acc.add(selected)
//   acc
// }
// println(results)
// println(resultlist.filter {
//   it.length > 0
// })