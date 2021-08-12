//https://www.acmicpc.net/problem/15654

//N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

//N개의 자연수 중에서 M개를 고른 수열

const solution = (n, m) => {
  const arr = Array(m).fill(0)
  const visited = Array(n).fill(0)

  const dfs = (n, m, d) => {
    if (d == m) {
      console.log(arr)
      return
    }

    for (let i = 1; i < n + 1; i++) {
      if (visited[i - 1] == 1) continue
      arr[d] = i
      visited[i - 1] = 1
      dfs(n, m, d + 1)
      visited[i - 1] = 0
    }
  }
  dfs(n, m, 0)
  return
}


solution(4, 2)
