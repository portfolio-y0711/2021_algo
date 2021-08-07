// https://programmers.co.kr/learn/courses/30/lessons/42587

function solution(priorities, location) {
  const priority_queue = priorities.map((x, idx) => [x, idx])

  let p, order = 0
  while (priority_queue.length) {
    [p, idx] = priority_queue.splice(0, 1)[0]
    const max = Math.max(...priority_queue.map(x => x[0]))
    if (p < max) {
      priority_queue.push([p, idx])
    } else {
      order++
      if (idx == location) {
        break
      }
    }
  }
  return order
}

console.log(
  solution(
    [ 2, 1, 3, 2 ],
    2,
  )
)