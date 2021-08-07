// https://programmers.co.kr/learn/courses/30/lessons/43238

function solution(n, times) {
  var answer = 0;
  let left = 1;
  let right = Math.max(...times) * n;
  let mid, total;

  while (left < right) {
    mid = Math.floor((left + right) / 2, 0);
    total = times.reduce((total, t) => {
      total += Math.floor(mid / t, 0);
      return total
    }, 0) 
    // console.log(`left: ${left}, mid: ${mid}, right: ${right}, total: ${total}`)
    if (total >= n) {
      // console.log(`left: ${left}, mid: ${mid}, <- right: ${mid}, total: ${total}`)
      right = mid;
    } else {
      // console.log(`left: ${mid + 1}, ->  mid: ${mid}, right: ${right}, total: ${total}`)
      left = mid + 1;
    }
    answer = left;
  }
  return answer;
}

console.log(solution(10, [10, 10]))
// solution(6, [7, 10])