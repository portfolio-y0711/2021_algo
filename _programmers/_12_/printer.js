// https://programmers.co.kr/learn/courses/30/lessons/42587

function solution(priorities, location) {
  const _priorities = priorities.map((x, i) => [x, i])
  let p, max, i
  let counter = 0
  while (_priorities.length) {
    [p, i] = _priorities.splice(0, 1)[0]
    max = Math.max(..._priorities.map(x => x[0]))
    // console.log(`p: ${p}, i: ${i}`)
    if (p < max) {
      _priorities.push([p, i])
    } else {
      counter++;
      if (i == location) {
        break;
      }
    }
  }
  return counter
}

console.log(
  solution(
  [2, 1, 3, 2],
  2
  )
)