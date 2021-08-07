// https://programmers.co.kr/learn/courses/30/parts/12077

const getRandomFixture = (genres, each) => {
  const maxIdx = genres.length
  const genGenres = () => genres[Math.floor(maxIdx * Math.random())]
  const genPlays = () => Math.floor(Math.random() * 100 + 100)
  const _genres =  [...Array(each)]
          .map(_ => genGenres())
  const _plays =  [...Array(each)]
          .reduce((acc, _) => {
              let curr = -1
              do {
                  curr = genPlays()                
              } while (acc.includes(curr) || (curr == -1))
              acc.push(curr)
              return acc
          }, [])
  return [_genres, _plays]
}

const zip = (a, b) => {
  const arrAB = [[a], [b]]
  return arrAB[0].map((arrA, indexA) => {
    const _arrAB = arrA.map((_a, indexB) => {
      const arrB = arrAB[1][indexA]
      const _b = arrB[indexB]
      return [_a, _b]
    })
    return _arrAB
  })
}

const solution = (genres, plays) => {
  const genreMap = zip(genres, plays)
    .flatMap(x => x)
    .map((x, idx) => {
        return [...x, idx]
      })
    .reduce((genreMap, [g, p, pIdx]) => {
      (!(g in genreMap)) 
        ?  (genreMap[g] = [[p, pIdx]])
        : (genreMap[g] = [...genreMap[g], [p, pIdx]])
      return genreMap
  }, {})
    
  const genreEntriesSortedBySum = Object
    .entries(genreMap)
    .sort((a, b) => {
      const sumB = b[1].reduce((acc, curr) => acc + curr[0], 0)
      const sumA = a[1].reduce((acc, curr) => acc + curr[0], 0)
      return sumB - sumA
    })

  const selectedList = genreEntriesSortedBySum
    .map(entry => {
      const sortedPlaylist = entry[1]
        .sort((a, b) => b[0] - a[0])
      const take2fromList = sortedPlaylist
        .map((p, idx) => (idx < 2) ? p : null)
        .filter(x => x !== null)
        .map(x => x[1])
      return take2fromList
    })

  return selectedList.flatMap(x => x).filter(x => x !== null)
}
