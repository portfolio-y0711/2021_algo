// https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*

// 다리의 길이, 최대 중량, 트럭 중량 리스트가 주어짐
// 시간을 담을 변수를 0으로 초기화함
// 먼저 다리를 건너는 트럭을 표현하기 위해 다리의 길이 크기의 큐를 생성하고 0으로 초기화함
// 다음으로 트럭 중량이 담을 큐를 생성하고 리스트를 순회하며 관련 요소를 옮김
// 다리를 건너는 트럭 큐가 소진될때까지 recursive loop로 순회를 반복함
// 루프 내에서 시간 카운터가 하나 증가하며, 다리를 건너는 트럭 큐에서 하나의 요소를 polling함
// 대기열의 트럭 중 첫번째 요소와 다리를 건너는 트럭의 총 중량을 합한 값을 총중량과 비교
// 만일 값이 작으면 대기열의 트럭에서 요소를 하나 뽑아서 다리를 건너는 트럭 큐에 추가함
// 만일 값이 크면 대기열의 트럭에서 요소를 뽑는 댓딘 다리를 지나는 트럭 큐에 0을 추가함
// 모든 요소를 순회한 이후에는 경과된 시간 카운터를 반환함

class Solution02 {
  fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
      var time = 0
      var trucksOnBridge: Queue<Int> = LinkedList()
      var truckQ: Queue<Int> = LinkedList()

      for (i in 0 until bridge_length) {
        trucksOnBridge.add(0)
      }

      for (i in 0..truck_weights.lastIndex) {
        truckQ.offer(truck_weights[i])
      }

      while (!trucksOnBridge.isEmpty()) {
        trucksOnBridge.poll()
        if (!truckQ.isEmpty()) {
          val totalWeight = trucksOnBridge.fold<Int, Int>(0) { 
            a, b -> a + b 
          }
          if (totalWeight + truckQ.peek() <= weight) {
            val truck = truckQ.poll()
            trucksOnBridge.add(truck)
          } else {
            trucksOnBridge.add(0)
          }
          time++
        }
      }
      return time
  }
}

fun main(args: Array<String>) {
    Solution02()
      .solution(2, 10, intArrayOf(7, 4, 5, 6))
}