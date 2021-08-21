# https://www.acmicpc.net/problem/2206

# N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

# 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

# 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

# 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

# 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

# 첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

# 6 4
# 0100
# 1110
# 1000
# 0000
# 0111
# 0000

# 15

# 4 4
# 0111
# 1111
# 1111
# 1110

# -1


# 최단 경로를 따라가는 BFS 알고리즘의 특성을 이용한 미로찾기와 비슷하지만, 벽 부수기라는 새로운 요소가 추가된 문제였다. 미로찾기 문제와 비슷하게 visited를 만들되, 각 칸이 요소를 2개씩 가진 3차원 배열을 만들어주었다.

# visited[x][y][w] 에서 w가 0이라면 벽을 한번 뚫은 상태이고, 1이라면 아직 벽을 한번 뚫을 수 있는 상태를 나타닌다.

# BFS 알고리즘을 순환하면서, 벽을 뚫을 수 있는 상태이고, 벽을 만난다면 벽을 뚫어주고 + 1을 해준다. 아직 방문하지 않았고 벽이 아니라면 + 1을 해준다.


# import sys

# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]


# def bfs():
#     q = []
#     q.append([0, 0, 1])
#     visit = [[[0] * 2 for _ in range(m)] for __ in range(n)]
#     visit[0][0][1] = 1
#     while q:
#         x, y, w = q.pop(0)
#         if x == n - 1 and y == m - 1:
#             return visit[x][y][w]
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0 <= nx < n and 0 <= ny < m:
#                 if location[nx][ny] == 1 and w == 1:
#                     visit[nx][ny][0] = visit[x][y][1] + 1
#                     q.append([nx, ny, 0])
#                 elif location[nx][ny] == 0 and visit[nx][ny][w] == 0:
#                     visit[nx][ny][w] = visit[x][y][w] + 1
#                     q.append([nx, ny, w])
#     return -1


# n, m = map(int, sys.stdin.readline().split())
# location = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]
# print(bfs())


# 출처: https://ca.ramel.be/82 [MemoLOG]