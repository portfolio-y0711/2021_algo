// https://programmers.co.kr/learn/courses/30/lessons/43162

const dfs = (n, computers, visited, start) => {
  const stack = [start]
  let i
  while (stack.length) {
    i = stack.pop()

    if (visited[i] == 0) {
      visited[i] = 1
    }
    [...Array(n).keys()].forEach(j => {
      if ((computers[i][j] == 1) && (visited[j] == 0)) {
        stack.push(j)
      }
    })
  }
}

function solution(n, computers) {
  const visited = Array(n).fill(0);
  let answer = 0;

  [...Array(n).keys()].forEach(i => {
    if (! visited[i]) {
      dfs(n, computers, visited, i)
      answer += 1
    }
  })
  return answer
}

console.log(solution(3, [
  [
    1, 1, 0
  ],
  [
    1, 1, 1
  ],
  [
    0, 1, 1
  ]
]))
