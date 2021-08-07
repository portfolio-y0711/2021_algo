//https://www.acmicpc.net/problem/15651
//N과 M (3)

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  // private int[] visited;
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
      // visited[i] = 1;
      arr[d] = i + 1;
      dfs(n, m, d + 1);
      // visited[i] = 0;
    }
  }

  public void solution(int n, int m) {
    // visited = new int[n];
    arr = new int[m];
    // Arrays.fill(visited, 0);
    Arrays.fill(arr, 0);
    dfs(n, m, 0);
  }
}

public class Index {
  public static void main(String[] args) {
    new Solution() 
      .solution(4, 2);
  }
}