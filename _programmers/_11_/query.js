// https://programmers.co.kr/learn/courses/30/lessons/72412

function solution(info, query) {
  const infos = info
    .map(x => x.split(' '))
    .reduce((acc, curr) => {
      acc.push(curr)
      return acc
    }, [])

  const queries = query
    .map(x => x.replace(/\sand\s/gi, ' ').split(' '))
  
  const result = queries
    .reduce((_infos, qs) => {
      return qs.reduce((_is, q) => {
        const p = parseInt(q)
        if (!isNaN(p)) {
          _is = _is.filter(info => info[4] > p)
        } else {
          _is = _is.filter(info => info.includes(q))
        }
        return _is
      }, _infos)
  }, infos)

  console.log(result)
  return 
}


// console.log(
  solution(
    [
      "java backend junior pizza 150",
      // "python frontend senior chicken 210",
      // "python frontend senior chicken 150",
      // "cpp backend senior pizza 260",
      // "java backend junior chicken 80",
      // "python backend senior chicken 50"
    ],
    [
      "java and backend and junior and pizza 100",
      // "python and frontend and senior and chicken 200",
      // "cpp and - and senior and pizza 250",
      // "- and backend and senior and - 150",
      // "- and - and - and chicken 100",
      // "- and - and - and - 150"
    ]	 
  )
// )

// [1,1,1,1,2,4]
