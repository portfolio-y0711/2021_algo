//https://www.acmicpc.net/problem/15649
//N과 M (1)

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열


const solution = (n, m) => {
  const arr = Array(m).fill(0)
  const visited = Array(n).fill(0)

  const dfs = (n, m, d) => {
    if (d == m) {
      console.log(arr)
      return
    }

    for (let i = 0; i < n; i++) {
      if (visited[i] == 1) continue
      visited[i] = 1
      arr[d] = i + 1
      dfs(n, m, d + 1)
      visited[i] = 0
    }
  }

  dfs(n, m, 0)
  return
}


solution(4, 2)



