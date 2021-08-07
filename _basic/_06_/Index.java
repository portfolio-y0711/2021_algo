//https://www.acmicpc.net/problem/15655

//N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

//N개의 자연수 중에서 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  private int[] visited;
  private int[] arr;

  public void dfs(int n, int m, int d) {
    if (d == m) {
      System.out.println(
        Arrays
          .stream(arr)
          .boxed()
          .collect(Collectors.toList())
      );
      return;
    }

    for (int i = 0; i < n; i++) {
      if ((d > 0) && (i < arr[d - 1])) continue;
      arr[d] = i + 1;
      visited[d] = 1;
      dfs(n, m, d + 1);
      visited[d] = 0;
    }
  }

  public void solution(int n, int m) {
      visited = new int[n];
      arr = new int[m];
      Arrays.fill(visited, 0);
      Arrays.fill(arr, 0);
      dfs(n, m, 0);
  };
}

public class Index {
  public static void main(String[] args) {
    new Solution() 
      .solution(4, 2);
  }
}