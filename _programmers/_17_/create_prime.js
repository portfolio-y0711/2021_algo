const comb = (n, r) => {
  const resultlist = []
  const DFS = (L, start, result) => {
    if (L == r) {
      resultlist.push([...result])
      result = []
    } else {
      for (let i = start; i < n.length; i++) {
        result.push(n[i])
        DFS(L + 1, i + 1, result)
        result.pop()
      }
    }
  }
  DFS(0, 0, [])
  return resultlist
}

const isPrime = (num) => {
  let _isPrime = true;
  let upper = Math.floor(Math.sqrt(num))

  for (let i = 2; i <= upper; i++) {
    if (num % i === 0) {
      _isPrime = false;
      break;
    }
  }
  return _isPrime
}


console.log(
comb([1,2,3,4], 3)
  .reduce((counter, curr) => {
    const number = curr.reduce((acc, n) => acc + n)
    // console.log(`curr: ${curr}, isprime: ${isPrime(number)}`)
    if (isPrime(number)) {
      counter++
    }
    return counter
  }, 0)
)