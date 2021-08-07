

// const n = [1,2,3]
// const r = 2

// const result = Array(r).fill(0)
// const checklist = Array(n.length).fill(0)

const perm = (n) => {
  const r = n.length
  const resultlist = []
  // const result = Array(r).fill(0)

  const DFS = (n, depth, result) => {
    // console.log(' '.repeat(depth) + `--- current depth: ${depth}`)
    if (depth == r) {
      resultlist.push([...result])
      // console.log(' '.repeat(depth) + `result: ${result}`)
    } else  {
      for (let i of Array(n.length).keys()) {
          // result[depth] = n[i]
          result.push(n[i])
          console.log(' '.repeat(depth) + `i: ${i}, result: ${result}`)
          DFS(n.filter((_, idx) => i !== idx), depth + 1, [...result])
          result.pop()
      }
    }
  }
  DFS(n, 0, [])
  return resultlist
}

// console.log(
// perm([1, 2, 3, 4], 2)
// perm([6, 10, 2])
// )

const solution = (numbers) => {
  const permutations = perm(numbers)
  const max = permutations.reduce((_max, curr) => {
    const curNum = parseInt(curr.map(x => x.toString()).join(''))
    if (curNum > _max) {
      _max = curNum
    }
    return _max
  }, 0)
  return max
}

console.log(
solution([ 6, 10, 2 ])
)


// console.log(result)
// console.log(checklist)