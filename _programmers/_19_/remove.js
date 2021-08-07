const solution = (s) => {
  return s.split('').reduce((acc, curr) => {
    if (!acc.length) {
      acc.push(curr)
    } else {
      if (acc[acc.length - 1] == curr) {
        acc.pop()
      } else {
        acc.push(curr)
      }
    }
    return acc
  }, []).length > 0 ? 0 : 1
}

console.log(
  solution(
    'baabaa'
    // 'cdcd'
  ),
)