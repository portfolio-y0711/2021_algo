// https://www.acmicpc.net/problem/11725

// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
// 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


class Solution {
  LinkedList<Integer>[] tree;
  int [] parents;

  public void dfs(int _node) {
    for (int i : tree[_node]) {
      if (parents[i] == 0) {
        parents[i] = _node;
        dfs(i);
      }
    }
  }

  public void solution(int n, int[][] nodes) {
    tree = new LinkedList[n + 1];
    parents = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
      tree[i] = new LinkedList<Integer>();
      parents[i] = 0;
    }

    for (int[] node: nodes) {
      tree[node[0]].add(node[1]);
      tree[node[1]].add(node[0]);
    }

    dfs(1);

      IntStream
        .range(2, parents.length)
        .forEach(i -> System.out.println(parents[i]));
  }
}

public class Index {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] nodes = new int[n - 1][];

    StringTokenizer st;
    int a, b;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      nodes[i] = new int[]{ a, b };
    }
    
    new Solution()
      .solution(n, nodes);

    // Arrays
    //   .stream(nodes)
    //   .forEach(x -> System.out.println(
    //     Arrays.toString(x)
    //   )
    // );

    // new Solution() 
    //   .solution(
    //     7,
    //     new int[][] {
    //       new int[] { 1, 6 },
    //       new int[] { 6, 3 },
    //       new int[] { 3, 5 },
    //       new int[] { 4, 1 },
    //       new int[] { 2, 4 },
    //       new int[] { 4, 7 }
    //     }
    //   );
  }
}

