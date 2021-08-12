import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1260

// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
// 정점 번호는 1번부터 N번까지이다.

// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
// 입력으로 주어지는 간선은 양방향이다.

// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
// V부터 방문된 점을 순서대로 출력하면 된다.

// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4

// 1 2 4 3
// 1 2 3 4

// 5 5 3
// 5 4
// 5 2
// 1 2
// 3 4
// 3 1

// 3 1 2 5 4
// 3 1 4 2 5

class Solution {
  private LinkedList<Integer> visited;
  LinkedList<Integer>[] edge;

  public void dfs(int v) {
    visited.add(v);
    for (int node: edge[v]) {
      if (!(visited.contains(node))) {
        dfs(node);
      }
    }
  }

  public void bfs(int v) {
    visited.add(v);
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(v);

    int node;
    while (q.size() > 0) {
      node = q.poll();
      for (int n: edge[node]) {
        if (!(visited.contains(n))) {
          q.add(n);
          visited.add(n);
        }
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] nmv = Arrays
      .stream(br.readLine().split(" "))
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();

    int n = nmv[0];
    int m = nmv[1];
    int v = nmv[2];

    edge = new LinkedList[n + 1];
    for (int i = 0; i < n + 1; i++) {
      edge[i] = new LinkedList<Integer>();
    }

    for (int i = 0; i < m; i++) {
      int[] ab = Arrays
        .stream(br.readLine().split(" "))
        .mapToInt(s -> Integer.parseInt(s))
        .toArray();

      int a = ab[0];
      int b = ab[1];
      edge[a].push(b);
      edge[b].push(a);
    }

    for (LinkedList<Integer> list: edge) {
      Collections.sort(list);
    }

    // System.out.println(Arrays.asList(edge).stream().collect(Collectors.toList()));

    visited = new LinkedList<>();
    dfs(v);
    System.out.println(
      visited.stream().map(i -> (String) i.toString()).collect(Collectors.joining(" "))
    );

    visited = new LinkedList<>();
    bfs(v);
    System.out.println(
      visited.stream().map(i -> (String) i.toString()).collect(Collectors.joining(" "))
    );

  }
}

public class Index {
  public static void main(String[] args) throws IOException {
      new Solution()
        .solution();
  }
}