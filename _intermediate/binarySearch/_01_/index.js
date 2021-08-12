// https://www.acmicpc.net/problem/1654

// 집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.
// 이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 
// 그러나 K개의 랜선은 길이가 제각각이다. 
// 박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
//  예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. 
// (이미 자른 랜선은 붙일 수 없다.)
// 편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자. 
// 그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

// - pseudo code - 
// 이미 가지고 있는 랜선의 개수인 K와 캠프에 사용할 랜선의 개수인 N개를 입력받음
// K개 랜선의 길이를 추가로 입력받음
// K개의 랜선 중 가장 긴 랜선이 upper bound(right)
// 1이 lower bound(left)가 됨
// (left + right)를 반으로 나눈 몫이 중간값 mid가 됨
// mid로 k개 랜선을 잘랐을 때 mid 몫의 개수가 N개 이상인지 이하인지 판단
// N개 이상인 경우 구간의 시작점을 mid + 1로 이동시킴
// N개 이하인 경우 구간의 종료점을 mid - 1로 이동시킴

const solution = (n, codes) => {
  let left = 1, right = Math.max(...codes), mid, lines

  while (left <= right) {
    lines = 0
    mid = Math.floor((left + right) / 2)

    for (let code of codes) {
      lines += Math.floor(code / mid)
    }

    if (lines >= n) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
}

solution(
  11,
  [
    802,
    743,
    457,
    539
  ]
)