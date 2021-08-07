// https://programmers.co.kr/learn/courses/30/lessons/43162


function solution(n, computers) {
  const visited = Array(n).fill(0)
  const traverse = (n, computers, visited, i) => {
    const stack = [i]
    let node
    while (stack.length) {
      node = stack.pop()

      if (visited[node] == 0) {
        visited[node] = 1
      }

      for (let j = 0; j < n; j++) {
        if (!(computers[i][j] == 1) && (visited[j] == 0)) {
          stack.push(j)
        }
      }
    }
  }
  let counter = 0
  for (let i = 0; i < n; i++) {
    if (! visited[i]) {
      traverse(n, computers, visited, i)
      counter++
    }
  }
  return counter
}

console.log(
solution(
  3,
  [[1, 1, 0], [1, 1, 0], [0, 0, 1]]	
)
)