// https://www.acmicpc.net/problem/1260

// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
// 정점 번호는 1번부터 N번까지이다.

// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
// 입력으로 주어지는 간선은 양방향이다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
  private HashMap<String, String[]> nodes;

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    nodes = new HashMap();

    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      nodes.put(s[0], new String[] { s[1], s[2] });
    }
    preorder("A");
    System.out.println();
    inorder("A");
    System.out.println();
    postorder("A");
  }
  public void preorder(String node) {
    if (node.equals(".")) {
      return;
    }
    System.out.print(node);
    preorder(nodes.get(node)[0]);
    preorder(nodes.get(node)[1]);
  }

  public void inorder(String node) {
    if (node.equals(".")) {
      return;
    }
    inorder(nodes.get(node)[0]);
    System.out.print(node);
    inorder(nodes.get(node)[1]);
  }

  public void postorder(String node) {
    if (node.equals(".")) {
      return;
    }
    postorder(nodes.get(node)[0]);
    postorder(nodes.get(node)[1]);
    System.out.print(node);
  }
}

public class Index {
 
  public static void main(String[] args) throws Exception {
    new Solution() 
      .solution();
  }

}