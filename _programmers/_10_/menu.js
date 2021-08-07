// https://programmers.co.kr/learn/courses/30/lessons/72411?language=kotlin

const comb = (arr, selectNumber) => {
  if (selectNumber === 1) 
    return arr.map((value) => [value]);

  const results = arr.reduce((acc, selected) => {
    const idx = arr.findIndex(e => e == selected)
    const rest = [
      // ...arr.slice(0, idx),
      ...arr.slice(idx + 1)
    ] 
    const restSelec = comb(rest, selectNumber - 1);
    const attached = restSelec.map((restSelected) => [
      selected,
      ...restSelected
    ]);
    acc.push(... attached); 
    return acc
  }, []);

  return results; 
};


function solution(orders, course) {
  const result = []
  for (let n of course) {
    const combinations = orders.reduce((result, order) => {
      comb(order.split('').sort(), n)
        .map(x => x.join(''))
        .forEach((x) => {
          if (!(x in result)) {
            result[x] = 1
          } else {
            result[x] = result[x] + 1
          }
          return result
        })
      return result
    }, {})
    const list = Object.entries(combinations)
    const maxCounter = list.reduce((max, curr) => {
      if (max < curr[1]) {
        return curr[1]
      } else {
        return max
      }
    }, 0)
    list.forEach(x => {
      if (x[1] == maxCounter && maxCounter > 1) result.push(x[0])
    })
  }
  return result.sort()
}

console.log(
  solution(
    // [
    //   "ABCFG", 
    //   "AC", 
    //   "CDE", 
    //   "ACDE", 
    //   "BCFG", 
    //   "ACDEH"
    // ],
    // [
    //   2,
    //   3,
    //   4
    // ]

    // ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"],
    // [2,3,5]	

    ["XYZ", "XWY", "WXA"],
    [2,3,4]	
  )
)