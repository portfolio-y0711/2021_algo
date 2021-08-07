function solution(operations) {
  const table = {
    I: (list, val) => {
      return [...list, parseInt(val)]
    },
    D: (list, val) => {
      let max, min
      switch(val) {
        case '1':
          max = Math.max(...list)
          return list.filter(e => e !== max)
        case '-1':
          min = Math.min(...list)
          return list.filter(e => e !== min)
        default:
          throw Error()
      }
    },
  }
  const result = operations.reduce((list, operation) => {
    const [op, val] = operation.split(' ')
    const acc = table[op](list, val)
    return acc
  }, [])
  return result.length ? [ Math.max(...result) , Math.min(...result) ] : [0, 0] 
}