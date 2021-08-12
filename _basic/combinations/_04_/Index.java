//https://www.acmicpc.net/problem/15652

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.
//고른 수열은 비내림차순이어야 한다.
//길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  private int[] arr;
  // private int[] visited;

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
      dfs(n, m, d + 1);
    }
  }
  public void solution(int n, int m) {
    arr = new int[m];
    dfs(n, m, 0);
  }
}

public class Index {
  public static void main(String[] args) {
    new Solution()    
      .solution(4, 2);
  }
}
