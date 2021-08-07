function solution(participant, completion) {
  const _participant = participant
    .reduce((acc, curr) => {
      if (!(curr in acc)) {
        acc[curr] = 1
      } else {
        acc[curr] += 1
      }
      return acc
    }, {})

  for (let comp of completion) {
    _participant[comp] -= 1
  }
  
  return Object.entries(_participant)
    .filter(e => e[1] > 0)[0][0]
}

console.log(solution(
  ["leo", "kiki", "eden"],
  ["eden", "kiki"]
))