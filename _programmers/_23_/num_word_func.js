const solution = (s) => {
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
  let word = ''
  return parseInt(s.split('').reduce((numbers, c) => {
    if (!isNaN(c)) {
      numbers = [...numbers, c]
    } else {
      word += c
      if (wordlist.includes(word)) {
        numbers = [...numbers, wordmap[word]]
        word = ''
      }
    }
    return numbers
  }, []).join(''))
}

console.log(
  solution(
    "one4seveneight",
    // "23four5six7",
    // "2three45sixseven",
    // "123",
  )
)