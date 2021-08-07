// https://programmers.co.kr/learn/courses/30/lessons/43162

const traverse = (n, computers, visited, i) => {
  const stack = [i]
  let node
  while (stack.length) {
    node = stack.pop()
    
    if (visited[node] == 0) {
      visited[node] = 1
    }

    for (const j in [...Array(n).keys()]) {
      if (!(computers[i][j] == 1) && (visited[j] == 0)) {
        stack.push(j)
      }
    }
  }
}


function solution(n, computers) {
  const visited = Array(n).fill(0)
  let answer = 0
  for (const i in [...Array(n).keys()]) {
    if (! visited[i]) {
      traverse(n, computers, visited, i)
      answer += 1
    }
  }
  return answer
}

console.log(
  solution(
    3,
    [
      [1, 1, 0], 
      [1, 1, 0], 
      [0, 0, 1]
    ],    
  )
)