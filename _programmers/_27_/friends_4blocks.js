// https://programmers.co.kr/learn/courses/30/lessons/17679

function solution(m, n, board) {

  const checkMatched = (...args) => {
    let isMatched = true
    args[0] == args[1] || (isMatched = false)
    args[0] == args[2] || (isMatched = false)
    args[0] == args[3] || (isMatched = false)
    return isMatched
  }
  let matchArr = []
  for (let i = 1; i < m - 1; i++) {
    for (let j = 0; j < n - 1; j++) {
      if (isMatched = checkMatched(board[i][j], board[i][j + 1], board[i + 1][j], board[i + 1][j + 1])) {
        matchArr.push([i, j])
      }
    }
  }
  matchArr.forEach(cursor => {
    const [x, y] = cursor
    board[x][y] = board[x + 1][y] = board[x][y + 1] = board[x + 1][y + 1] = 0
  })


  // const restruct = () => {
  // }
}

// 판의 높이 m, 폭 n, 보드 정보 board가 인자로 들어옴
// 종료조건. 체크하기 수행 후 isErasable 플래그가 false이면 종료
// 체크하기
// 가로폭 n - 1, 세로폭 m - 1의 범위를 순회하며 정사각형 창문으로 이미지를 검색함
// 좌표 커서에 위치한 문자를 포함한 창문 4개의 문자와 모두 일치하면 공백문자로 변환
// 지우고 내리기
// m에서 0 (위쪽 방향), 0에서 n방향을 순회 
// 1) 공백문자 카운트
// 2) 0 (위쪽 방향으로 이동하며), 문자를 만날때까지 공백 개수(space)를 센 뒤 문자가 있으면 해당 문자만큼 위에 있는 문자들을 아래로 이동(y좌표 + space)시킴




// console.log(
  // solution(
  //   4,
  //   5,
  //   [
  //     "CCBDE", 
  //     "AAADE", 
  //     "AAABF", 
  //     "CCBBF"
  //   ]	
  // )
// )

// solution(
//   6,
//   6,
//   [
//   "TTTANT", // 0 1 2 3 4 5 | 0 ~ n 
//   "RRFARR", // 1       *  
//   "RRRFRR", // 2                      
//   "TRRRAA", // 3             
//   "TTMMMF", // 4*            
//   "TMMTTJ"  // 5            
//   ]           // 0 ~ m	- 1   
// )
solution(
  6,
  6, 
  [
    "TTTANT", 
    "RRFACC", 
    "RRRFCC", 
    "TRRRAA", 
    "TTMMMF", 
    "TMMTTJ"
  ]	
)