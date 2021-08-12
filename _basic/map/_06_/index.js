function solution(stats) {
  let p, teams = []
  
  while (stats.length) {
    p = stats.shift()
    if (teams.length == 0) {
      const team = { max: p }
      teams.push(team)
    } else {
      let joined = false
      for (let i = 0; i < teams.length; i++) {
        if (p > teams[i].max) {
          teams[i].max = p  
          joined = true
          break
        }
      }
      if (!joined) {
        teams.push({ max: p })
      }
    }
  }
  return teams.length
}

console.log(
  solution(
    [6, 2, 3, 4, 1, 5]	
  )
)
