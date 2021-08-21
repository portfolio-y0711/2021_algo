// https://www.acmicpc.net/problem/11725

// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

// 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

// 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

const solution = (n, nodes) => {
  const Tree = new Array(n + 1)
    .fill(null)
    .map(_ => [])

  const Parents = new Array(n + 1)
    .fill(null)
    .map(_ => 0)
  
  for (const node of nodes) {
    const [a, b] = node
    Tree[a].push(b)
    Tree[b].push(a)
  }

  const dfs = (_node) => {
    for (let i of Tree[_node]) {
      if (Parents[i] == 0) {
        Parents[i] = _node
        dfs(i)
      }
    }
  }
  dfs(1)
  for (const i of Parents.slice(2)) {
    console.log(i)
  }
}


solution(
  7, 
  [
    [ 1, 6 ],
    [ 6, 3 ],
    [ 3, 5 ],
    [ 4, 1 ],
    [ 2, 4 ],
    [ 4, 7 ],
  ]
)