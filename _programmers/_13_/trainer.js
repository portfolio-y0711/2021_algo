// https://programmers.co.kr/learn/courses/30/lessons/42862

function solution (n, lost, reserve) {;
  const _lost = [...lost].filter(x => !reserve.includes(x))
  const _reserve = [...reserve].filter(x => !lost.includes(x))

  const covered = _lost.reduce((counter, _l) => {
    let unused = []
    let _r 
    while (_reserve.length) {
      _r = _reserve.splice(0, 1)[0]
      if (Math.abs(_l - _r) <= 1) {
        counter = counter + 1 
        break
      } else {
        unused.push(_r)
      }
    }
    _reserve.push(...unused)
    return counter
  }, 0)

  return n - _lost.length + covered
}

// console.log(
  solution(
    5,
    [2, 4],
    [1, 3, 5],
  )
// )