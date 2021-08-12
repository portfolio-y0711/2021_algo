
// https://www.acmicpc.net/problem/1157

// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

const readline = require('readline');
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

(async() => {
  const it = rl[Symbol.asyncIterator]()
  const word = (await it.next()).value.toUpperCase();
  rl.close();

  const chars = new Set(word.split(''))
  const counters = []

  for (x of Array.from(chars)) {
    let cnt = 0
    for (let i = 0; i < word.length; i++) {
      if (word[i] == x) cnt++
    }
    counters.push(cnt)
  }

  console.log(counters)
  const max = Math.max(...counters)
  console.log(max)

  if (counters.filter(x => x == max).length > 1) {
    console.log('?')
  } else {
    console.log([...chars][counters.findIndex(x => x == max)])
  }

})();



// let N; // 정수를 저장할 변수
// rl.on("line", function(line){
//     console.log(`print input string ${line}`);
//     N = Number(line);
//     console.log(`print input number ${N}`);
//     rl.close();
// })

// (async() => {
// for await (const line of rl) {
//   console.log(line)
// }

// })()