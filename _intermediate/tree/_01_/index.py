# https://www.acmicpc.net/problem/1991

# 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

# 예를 들어 위와 같은 이진 트리가 입력되면,

# 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
# 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
# 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
# 가 된다.

import sys
readline = sys.stdin.readline

def solution():
  N = int(input())
  nodes = {}

  for n in range(N):
    node, left, right = readline().split()
    # nodes[node] = [left, right]
    nodes[node] = (left, right)

  def preorder(node):
    nonlocal nodes
    if (node == '.'):
      return
    print(node, end = "") 
    preorder(nodes[node][0])
    preorder(nodes[node][1])

  def inorder(node):
    nonlocal nodes
    if (node == '.'):
      return
    inorder(nodes[node][0])
    print(node, end = "") 
    inorder(nodes[node][1])

  def postorder(node):
    nonlocal nodes
    if (node == '.'):
      return
    postorder(nodes[node][0])
    postorder(nodes[node][1])
    print(node, end = "") 

  preorder("A")
  print()
  inorder("A")
  print()
  postorder("A")

solution()