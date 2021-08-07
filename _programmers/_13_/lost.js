function solution(n, lost, reserve) {
  let _reserve = [... reserve]
  let _lost = [... lost]

  _lost = _lost.reduce((acc, _l) => {
    console.log(`_l: ${_l}`)
    const idx = _reserve.findIndex(e => e == _l)
    if (idx > -1) {
      _reserve.splice(idx, 1)
    } else {
      acc.push(_l)
    }
    return acc
  }, [])

  const _covered = _lost.reduce((acc, _l) => {
    console.log(`_l: ${_l}`)
    let _r,
      unused = []

    while (_reserve.length) {
      _r = _reserve.splice(0, 1)[0]
      // console.log(`lend: ${Math.abs(_l - _r)}`)
      if (Math.abs(_l - _r) <= 1) {
        acc = acc + 1
        break
      } else {
        unused.push(_r)
      }
    }
    _reserve.push(... unused)

    return acc
  }, 0)
  return n + _covered - lost.length
}
console.log(
  // solution(
  // 5,
  // [2, 4],
  // [1, 3, 5],
  // )
  solution(6, [
    1, 2, 4
  ], [3, 2, 5])
)
