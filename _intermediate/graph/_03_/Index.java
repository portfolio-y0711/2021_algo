
// https://www.acmicpc.net/problem/11724

// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
// (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
// (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

// 첫째 줄에 연결 요소의 개수를 출력한다.

// 6 5
// 1 2
// 2 5
// 5 1
// 3 4
// 4 6

// 2

// 6 8
// 1 2
// 2 5
// 5 1
// 3 4
// 4 6
// 5 4
// 2 4
// 2 3

// 1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Index {
  static class Solution {
    LinkedList<Integer>[] edges;
    boolean[] visited;

    public void dfs(int v) {
      visited[v] = true;
      for (int vertex : edges[v]) {
        if (visited[vertex] == false) {
          dfs(vertex);
        }
      }
    }

    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int[] NM = Arrays
        .stream(br.readLine().split(" "))
        .mapToInt(s -> Integer.parseInt(s)) 
        .toArray();

      int N = NM[0];
      int M = NM[1];

      edges = new LinkedList[N + 1];
      visited = new boolean[N + 1];

      for (int i = 1; i < N + 1; i++) {
        edges[i] = new LinkedList<Integer>();
        visited[i] = false;
      }

      for (int i = 0; i < M; i++) {
        int[] srcDst = Arrays
          .stream(br.readLine().split(" "))
          .mapToInt(s -> Integer.parseInt(s))
          .toArray();
        int src = srcDst[0];
        int dst = srcDst[1];
        edges[src].add(dst);
        edges[dst].add(src);
      }

      int counter = 0;
      for (int i = 1; i < N + 1; i++) {
        if (visited[i] == false) {
          dfs(i);
          counter++;
        }
      }
      System.out.println(counter);
    }
  }
  public static void main(String[] args) throws Exception {
    new Solution().solution();
  }
}