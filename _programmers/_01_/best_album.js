// https://programmers.co.kr/learn/courses/30/parts/12077

const zip = (a, b) => {
  const arrAB = [[a], [b]]
  return arrAB[0].map((arrA,indexA) => 
    arrA.map((_a, indexB) => {
      const _b = arrAB[1][indexA][indexB]
      return [_a, _b]
    })
  )
}

const zipWithIdx = (a, b) => zip(a,b)[0].map((x, idx) => [x[0], x[1], idx])

const solution = (genre,plays) => {
  const indexedZip = zipWithIdx(genre, plays)
  const genreMap = indexedZip
    .reduce((acc, curr) => {
      const [g, p, idx] = curr
      if (!(g in acc)) {
        acc[g] = [[p, idx]]
      } else {
        acc[g] = [...acc[g], [p, idx]]
      }
      return acc 
    }, {})

  const genreMapList = Object
    .entries(genreMap)
    .sort((entryA, entryB) => {
      const listA = entryA[1]
      const totalPA = listA.reduce((acc, curr) => {
        return acc + curr[0]
      }, 0)

      const listB = entryB[1]
      const totalPB = listB.reduce((acc, curr) => {
        return acc + curr[0]
      }, 0)
      return totalPB - totalPA
    })
    const albumList = genreMapList
      .reduce((acc, curr) => {
        const sorted = curr[1].sort((a, b) => b[0] - a[0])
        const take2 = sorted.map((p, idx) => (idx < 2) ? p : null)
          .filter(x => x)
        const extractIdx = take2.map(x => x[1])
        return [...acc, ...extractIdx]
      },[])
  return albumList
}

console.log(
solution(
  ["classic", "pop", "classic", "classic", "pop"]	,
  [500, 600, 150, 800, 2500],
)
)