const readline = require("readline")

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdin
});

(async() => {
  const it = rl[Symbol.asyncIterator]()
  const num = parseInt((await it.next()).value)

  let counter = 0
  const books = {}

  rl.on('line', (title) => {
    if (title in books) {
      books[title] += 1
    } else {
      books[title] = 1
    }

    
    if (++counter == num) {
      const booklist = []
      const max = Math.max(...Object.values(books))
      for ([key, value] of Object.entries(books)) {
        if (value == max) {
          booklist.push(key)
        }
      }
      booklist.sort((a, b) => 
        b.localeCompare(a)
      )

      console.log(booklist)
      rl.close()
    }
  })


})();