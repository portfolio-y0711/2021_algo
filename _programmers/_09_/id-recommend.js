// https://programmers.co.kr/learn/courses/30/lessons/72410

// 입력값으로 받은 아이디 문자열을 toLowerCase api를 이용해 변환
// 변환된 문자열 중 /w(알파벳) - _ . 집합에 속하지 않는 (^) 문자는 모두 (/g 옵션), 빈문자열로 치환하거나 필터링
// \.이 {2,} (2 번 이상의 의미하는 수량연산자) 반복될 경우 '.'으로 치환 또는 reduce 접기 연산시 조건문으로 누락처리함
// \.으로 시작(^\.)하거나 \.으로 종료(\.$)되는 두 가지 케이스를 모두 선택(연산)하여 '.'으로 치환함
// 이때 문자열 처리 결과가 비어있는(^$) 경우 문자열 'a'와 치환함
// 15자를 넘어서는 문자열은 자르기 연산으로 버린 이후, 맨 마지막 문자가 .으로 끝날 경우 (.$) 이를 빈문자열로 치환


function solution(new_id) {
  let id = new_id.split('')
    .map(c => {
      return c.toLowerCase()
    })
    .filter(c => 'abcdefghijklmnopqrstuvwxyz0123456789-_.'.includes(c))
    .reduce((acc, curr) => {
      if (!(acc.length > 0 && (acc[acc.length - 1] == '.') && (curr == '.'))) {
        acc.push(curr)
        return acc
      } 
      return acc
    }, [])
    .map((c, i, arr) => {
      if (c !== '.') {
        return c
      } else {
        if (!((i == 0 ) || (i == arr.length - 1))) {
          return c
        }
      }
    })
    .filter(x => x) 

  if (id.length == 0) {
    id = 'a'
  }
    
  id = id.splice(0, 15)

  if (id[id.length -1] == '.') {
    id = id.slice(0, -1)
  }

  while (id.length <= 2) {
    id = id + id[id.length -1]
  }
  return id.join('')
}

console.log(
  solution("abcdefghijklmn.p")
)
