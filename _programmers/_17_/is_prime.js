const isPrime = (num) => {
  let result = true
  const upper = Math.floor(Math.sqrt(num))
  for (let i = 2; i <= upper; i++) {
    if (num % i === 0) {
      result = false;
      break;
    }
  }
  return result;
}

// console.log(
[
  2,
  3,
  4,
  5,
  6,
  7,
  8
].forEach(x => {
  console.log(`x: ${x}, isPrime: ${
    isPrime(x)
  }`)
})
// )
