const solution = (s) => {
  const numbers = []
  const wordmap = {
    'zero': 0,
    'one': 1,
    'two': 2,
    'three': 3,
    'four': 4,
    'five': 5,
    'six': 6,
    'seven': 7,
    'eight': 8,
    'nine': 9,
  }
  const wordlist = Object.keys(wordmap)
  // console.log(wordlist)
  let word = ''
  for (let c of s) {
    if (!isNaN(c)) {
      numbers.push(c) 
    } else {
      word += c
      if (wordlist.includes(word)) {
        numbers.push(wordmap[word])
        word = ''
      }
    }
  }
  return parseInt(numbers.join(''))
}

console.log(
  solution(
    "one4seveneight",
    // "23four5six7",
    // "2three45sixseven",
    // "123",
  )
)