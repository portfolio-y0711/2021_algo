// https://www.acmicpc.net/problem/1991

// 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

// 예를 들어 위와 같은 이진 트리가 입력되면,

// 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
// 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
// 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
// 가 된다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
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