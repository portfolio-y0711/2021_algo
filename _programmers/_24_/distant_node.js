// https://programmers.co.kr/learn/courses/30/lessons/49189

const solution = (n, edge) => {
  return BFS(1, edge, n)
}

const BFS = (start, arr, end) => {
  const queued = new Array(end + 1).fill(false)
  const level = new Array(end + 1).fill(0)
  const queue = [start]
  queued[start] = true

  while (queue.length) {
    const head = queue.shift()
    // console.log(`head: ${head}`)
    const lev = level[head] + 1

    for (let node of arr) {
      if (node[0] === head && !queued[node[1]]) {
        queue.push(node[1])
        // console.log(queue)
        queued[node[1]] = true
        level[node[1]] = lev
      } else if (node[1] === head & !queued[node[0]]) {
        queue.push(node[0])
        queued[node[0]] = true
        level[node[0]] = lev
      }
    }
    // console.log(queue)
    // console.log(`visited: ${queued}`)
  }
  const maxLevel = Math.max.apply(null, level)
  return level.filter(i => i === maxLevel).length
}


// console.log(
  solution(
    6,
    [
      [ 3, 6 ],
      [ 4, 3 ],
      [ 3, 2 ],
      [ 1, 3 ],
      [ 1, 2 ],
      [ 2, 4 ],
      [ 5, 2 ]
    ]
  )
// )
