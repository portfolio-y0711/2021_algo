import java.util.*

// https://programmers.co.kr/learn/courses/30/lessons/43162

// 노드의 개수(n)와 간선 정보를 담은 리스트(computers)를 인자로 받음
// 방문 확인을 위해 0으로 초기화된 visited 배열을 생성함
// computers node를 순회한다
// node에 방문 여부를 확인한다 
// 처음에는 방문한 노드가 없으므로 첫번째 노드는 무조건 traverse 함
// traverse는 깊이 우선 탐색으로 간선으로 연결된 모든 노드를 방문하며, 다음 인자를 받음
// 1) 방문 여부를 기록하기 위한 visited 배열
// 2) 간선 정보가 담긴 computers 배열
// 3) 노드의 개수
// 4) 방문할 노드의 인덱스
// traverse는 먼저 인자로 받은 노드(인덱스)를 큐에 담고 visited에 방문을 표시함
// computers[i][j]로 간선 정보를 확인하며 방문하지 않은 노드를 큐에 추가함
// 방문을 마친 이후에는 counter를 증가시켜 방문한 네트워크의 개수를 기록

fun traverse (n: Int, computers: Array<IntArray>, visited: MutableList<Int>, curr: Int) {
  val q: Queue<Int> = LinkedList()
  q.add(curr)
  // println("curr: $curr")
  // println("visited: $visited")
  visited[curr] = 1
  var i: Int

  while (!q.isEmpty()) {
    i = q.poll()
    println("i: $i")

    for (j in 0 until n) {
      if ((computers[i][j] == 1) && (visited[j] == 0) ) {
        q.add(j)
        visited[i] = 1
      }
    }
    // println("q: $q")
  }
}

class Solution14 {
  fun solution(n: Int, computers: Array<IntArray>): Int {
    var counter = 0
    val visited = mutableListOf<Int>() 
    visited.addAll(0, IntArray(n) { 0 }.toList())
    
    for (i in 0 until n) {
      if (visited[i] == 0) {
        // println("-----")
        traverse(n, computers, visited, i)
        // println("visited: $visited")
        counter++
      }
    }
    return counter 
  }
}

fun main(args: Array<String>) {

println(
  Solution14()
    .solution(
      3, 
      arrayOf<IntArray>(
        intArrayOf(
          1, 
          1,
          0
        ),
        intArrayOf(
          1, 
          1,
          0
        ),
        intArrayOf(
          0, 
          0,
          1
        )
      )
    )
)
}