// https://programmers.co.kr/learn/courses/30/lessons/42890?language=kotlin

// 후보키
// 튜플 데이터의 조합을 구성함에 있어 선택함-선택하지 않음을 2진수 비트로 표현하고자 함
// 이를 위해 칼럼 개수를 2진수로 변환하기 위한 시프트 연산 수행함 
// 2^칼럼 개수에 해당하는 10진수를 루프로 순회하며 조합 생성함
// 튜플 데이터의 칼럼 시프트 연산을 통해 키를 하나라도 포함할 경우 레코드에 포함시킴

function solution(relation) {
  var combinations = [];
  var rows = relation.length;
  var columns = relation[0].length;

  for (var i = 1; i < (1 << columns); i++) {
    const keyMaps = {}
    for (let j = 0; j < rows; j++) {
      const records = [];
      for (let k = 0; k < columns; k++) {
        if (i & (1 << k)) {
          records.push(relation[j][k]);
        }
      }
      if (records.join("-") in keyMaps) {
        keyMaps[records.join("-")] = keyMaps[records.join("-")] + 1;
      } else {
        keyMaps[records.join("-")] = 1;
      }
    }
    // console.log(keyMaps)
    const isUnique = Object.keys(keyMaps).length == rows
    
    if (isUnique && isMinimal(combinations, i)) {
      combinations.push(i);
    }
  }

  function isMinimal(answers, now) {
    for (var i = 0; i < answers.length; i++) {
      // console.log(`answers[i] & now: ${answers[i] & now}, answers[i]: ${answers[i]}, result: ${(answers[i] & now) == answers[i]}`)
      if ((answers[i] & now) == answers[i]) {
        return false;
      }
    }

    return true;
  }
  return combinations.length;
}

console.log(
  solution(
  [
    ["100","ryan","music","2"],
    ["200","apeach","math","2"],
    ["300","tube","computer","3"],
    ["400","con","computer","4"],
    ["500","muzi","music","3"],
    ["600","apeach","music","2"]
  ]	
  )
)
