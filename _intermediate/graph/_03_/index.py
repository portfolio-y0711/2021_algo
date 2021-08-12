
# https://www.acmicpc.net/problem/11724

# 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

# 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
# (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
# (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

# 첫째 줄에 연결 요소의 개수를 출력한다.

# 6 5
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6

# [[], [2], [5], [4], [6], [1]]

# dfs
# 1 -> 2 
# 2 -> 5
# 5
# 3 -> 4
# 4 -> 6
# 6

# 2

# 6 8
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6
# 5 4
# 2 4
# 2 3

#[[],[2],[5,4,3],[4],[6],[1,4]]

# dfs
# 1 -> 2 [1]
# 2 -> 5 [1,2]
# 5 -> 4 [1,2,5]
# 4 -> 6 [1,2,5,4]
# 6 [1,2,5,4,6]
# 3 [1,2,5,4,6,3]

#bfs
# [2] 
# 2 [5,4,3] [2]


# 1


import sys
sys.setrecursionlimit(10000)

if __name__ == "__main__":
  N, M = map(int, sys.stdin.readline().split())
  edges = [[] for _ in range(N + 1)]
  visited = [False] * (N + 1)

  for i in range(1, M + 1):
    src,dst = map(int, sys.stdin.readline().split())
    edges[src].append(dst)
    edges[dst].append(src)


  def dfs(v):
    visited[v] = True
    for vertex in edges[v]:
      if not visited[vertex]:
        dfs(vertex)

  count = 0
  for i in range(1, N + 1):
    if visited[i] == False:
      count += 1
      dfs(i)
  print(count)

