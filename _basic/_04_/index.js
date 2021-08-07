//https://www.acmicpc.net/problem/15652

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.
//고른 수열은 비내림차순이어야 한다.
//길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

const solution = (n, m) => {

  const arr = (new Array(m)).fill(0)
  const visited = (new Array(n)).fill(0)

  const dfs = (n, m, d) => {
    
    if (d == m) {
      console.log(arr)
      return
    }

    for (let i = 1; i < n + 1; i++) {
      //visited[i] = 1
      if ((d > 0) && (i < arr[d - 1])) {
        continue
      }
      arr[d] = i 
      dfs(n, m, d + 1)
      //visited[i] = 0
    }

  }

  dfs(n, m, 0)
  return
}

solution(4, 2)
