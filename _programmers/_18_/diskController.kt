// https://programmers.co.kr/learn/courses/30/lessons/42627

import java.util.*

// 작업 요청이 들어온 시간과 작업 완료에 필요한 시간이 담긴 작업 목록 인자로 받음
// 시간을 기록하기 위한 변수를 0으로 초기화
// 응답시간을 누적 기록하기 위한 변수를 0으로 초기화
// 현재 기준으로 어디까지 작업이 되었는지를 인덱스를 기록하기 위한 cursor를 0으로 초기화
// 대기 중인(현재 시간에 작업 요청이 완료된) 작업들을 저장할 queue를 생성함
// 큐 생산: 커서가 가리키고 있는 작업의 예약 시간이 현재 시간 보다 작은지를 판단 (=요청이 끝난는지를 확인)
// 요청이 끝난 경우라면 커서를 하나 증가시킴
// 요청이 끝나지 않은 상태라면 커서를 증가시키지 않고 큐 소비로 넘어감
// 큐 소비: 큐에 작업이 남아 있는지 판단 
// 큐에 작업이 남아 있다면 하나씩 꺼내면서 현재의 시간에 작업 소요시간을 더해줌
// 큐가 비어 있으나 대기 중인 작업이 존재할 경우 바로 다음 대기 작업만큼 시간으로 현재 시간을 동기화함

class Solution18 {
  fun solution(jobs: Array<IntArray>): Int {
    var time = 0
    var cursor = 0
    var totalResponseTime = 0
    val compareByWorkTime: Comparator<Pair<Int, Int>> = compareBy { it.second }
    var queue: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareByWorkTime)
    var job: Pair<Int, Int>

    while (cursor < jobs.size) {
      //producing queue
      if (jobs[cursor][0] <= time) {
        queue.add(Pair(jobs[cursor][0], jobs[cursor][1]))
        cursor++
      }
      println("---")
      println(queue)
      
      // consuming queue
      if (queue.isEmpty()) {
        time = jobs[cursor][1]
      } else {
        job = queue.poll()
        time = time + job.second
        totalResponseTime = totalResponseTime + time - job.first
      }
      // println("totalResponseTime: $totalResponseTime")
      // println("cursor: $cursor")
    }

    return totalResponseTime
  }
}

fun main(args: Array<String>) {
  Solution18()
    .solution(
      arrayOf(
        intArrayOf(0, 3),
        intArrayOf(1, 9),
        intArrayOf(2, 6)
      )
    )
}
