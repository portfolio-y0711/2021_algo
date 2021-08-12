// https://www.acmicpc.net/problem/13023

// BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

// 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

// A는 B와 친구다.
// B는 C와 친구다.
// C는 D와 친구다.
// D는 E와 친구다.
// 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

const solution = (n, m) => {
  const dfs = (d, v) => {
    if (d == 4) { 
      exist = true
      return
    }
    visited[v] = true
    for (let vertex of edges[v]) {
      if (!visited[vertex]) {
        dfs(d + 1, vertex)
      }
    }
  }
  const edges = []
  const visited = []
  let exist = false
  for (let i = 0; i < n; i++) {
    edges[i] = []
    visited[i] = false
  }
  for (let i = 0; i < m.length; i++) {
   const src = m[i][0]
   const dst = m[i][1]
   edges[src].push(dst)
  }
  
  for (let i = 0; i < m.length; i++) {
    if (!visited[i]) {
      dfs(0, i)
      if (exist) {
        return 1
      } 
    }
    if (!exist) {
      return 0
    }
  }
}

console.log(
// solution(5, [
//   [0,1],
//   [1,2],
//   [2,3],
//   [3,4],
// ])
solution(6, [
  [0,1],
  [0,2],
  [0,3],
  [0,4],
  [0,5],
])
)