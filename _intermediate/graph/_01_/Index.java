import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

// https://www.acmicpc.net/problem/13023

// BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

// 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

// A는 B와 친구다.
// B는 C와 친구다.
// C는 D와 친구다.
// D는 E와 친구다.
// 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

// 5 4
// 0 1
// 1 2
// 2 3
// 3 4

// 1

// 5 5
// 0 1
// 1 2
// 2 3
// 3 0
// 1 4

// 1



class Solution {
  private boolean ans;
  boolean[] visited;
  LinkedList<Integer>[] edge;

  public void dfs(int v, int d) {
    visited[v] = true;
    if (d >= 4) {
      ans = true;
      return;
    }
    for (int node: edge[v]) {
      if (visited[node] == false) {
        dfs(node, d + 1);
        visited[node] = false;
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] nm = Arrays
      .stream(br.readLine()
      .split(" "))
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();

    int n = nm[0];
    int m = nm[1];

    edge = new LinkedList[n];

    for (int i = 0; i < n; i++) {
      edge[i] = new LinkedList<Integer>();
    }

    ans = false;
    visited = new boolean[n];
    Arrays.fill(visited, Boolean.FALSE);

    for (int j = 0; j < m; j++) {
      int[] ab = Arrays
        .stream(br.readLine().split(" "))
        .mapToInt(s -> Integer.parseInt(s))
        .toArray();

      int a = ab[0];
      int b = ab[1];
      edge[a].add(b);
      edge[b].add(a);
    }

    System.out.println(Arrays.asList(edge));


    for (int i = 0; i < n; i++) {
      dfs(i, 0);
      visited[i] = false;
      if (ans) break;
    }

    System.out.println((ans == true) ? 1 : 0);
  }
}

public class Index {
  public static void main(String[] args) throws IOException {
    new Solution() 
      .solution();
  }
}