const comb = (n, r) => {
  const cols = n.length
  const resultlist = []
  console.log(cols)
  console.log(1 << cols)
  // for (let i = 1; i <= (1 << cols) -1; i++) {
  //   console.log(i)
  // }
  // const DFS = (depth, begin, result) => {
  //   if (depth == r) {
  //     resultlist.push(result)
  //   }

  //   for (let i = begin; i <= n.length)

  //   console.log(depth)
  //   console.log(begin)
  //   console.log(result)
  // }
  // DFS(0, 0, [])
  return resultlist
}

function solution(relation) {
  comb(relation, relation[0].length)
}

solution(
[
  ["100","ryan","music","2"],
  ["200","apeach","math","2"],
  ["300","tube","computer","3"],
  ["400","con","computer","4"],
  ["500","muzi","music","3"],
  ["600","apeach","music","2"]
]	
)