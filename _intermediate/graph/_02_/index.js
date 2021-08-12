
// https://www.acmicpc.net/problem/1260

// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
// 정점 번호는 1번부터 N번까지이다.

const solution = (m, _edges, src) => {

  const edges = []
  const visited = []
  for (let i = 0; i < m + 1; i++) {
    edges[i] = []
    visited[i] = false
  }
  for (let edge of _edges) {
    const src = edge[0]
    const dst = edge[1]
    edges[src].push(dst)
    edges[dst].push(src)
  }

  const dfs = (v) => {
    process.stdout.write(v.toString())
    visited[v] = true
    for (let vertex of edges[v]) {
      if (!visited[vertex]) {
        dfs(vertex)
      }
    }
  }
  dfs(src)

  for (let i = 0; i < m + 1; i++) {
    visited[i] = false
  }
  console.log()

  const bfs = (v) => {
    let node
    const dq = [v]
    while (dq.length) {
      node = dq.splice(0, 1)[0]
      visited[node] = true
      process.stdout.write(node.toString())
      for (let vertex of edges[node]) {
        if (!visited[vertex] && !dq.includes(vertex)) {
          dq.push(vertex)
        }
      }
    }
  }
  bfs(src)
}

solution(
  4,
  [
    [1, 2],
    [1, 3],
    [1, 4],
    [2, 4],
    [3, 4],
  ],
  1
)