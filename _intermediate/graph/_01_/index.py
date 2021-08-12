# https://www.acmicpc.net/problem/13023

# BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

# 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

# A는 B와 친구다.
# B는 C와 친구다.
# C는 D와 친구다.
# D는 E와 친구다.
# 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

import sys
input = sys.stdin.readline

def solution():
  n, m = map(int, input().split())
  edge = [[] * m for i in range(n)]

  ans = False
  visited = [False for i in range(n)]

  for i in range(m):
    a, b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

  def dfs(v, d):
    nonlocal ans
    visited[v] = True

    if d >= 4:
      ans = True
      return

    for node in edge[v]:
      if not visited[node]:
        dfs(node, d + 1)
        visited[node] = False

  for i in range(n):
    dfs(i, 0)
    visited[i] = False
    if ans:
      break

  print(1 if ans else 0)

solution()
