# https://www.acmicpc.net/problem/14442

# N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

# 만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.

# 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

# 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

# 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 

# 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. 

# (1, 1)과 (N, M)은 항상 0이라고 가정하자.

# 첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

# 6 4 1
# 0100
# 1110
# 1000
# 0000
# 0111
# 0000

# 15

# 6 4 2
# 0100
# 1110
# 1000
# 0000
# 0111
# 0000

# 9

# 4 4 3
# 0111
# 1111
# 1111
# 1110

# -1


#  앞서 다룬 벽 부수고 이동하기 문제에서 경우의 수가 K로 추가된 문제이다. 해당 문제에서는 입력되는 K에 따라 벽을 부 술 수 있는 횟수가 증가하게 된다. 따라서 경우의 수는 벽을 부순 횟수가 (0, 1, ... K)로 증가된 문제이다. 벽 부수고 이동하기 코드에서 K에 대한 경우의 수를 추가해주면 해결 할 수 있다. (단, PyPy3로 제출하여야 시간 내에 통과할 수 있다.)



from sys import stdin
from collections import deque


def visitable(x, y, w):
    return 0 <= x < n and 0 <= y < m and not visited[x][y][w]


def bfs(start):
    q = deque([start])
    dirs = ((-1, 0), (0, 1), (1, 0), (0, -1))

    while q:
        cur_x, cur_y, wall = q.popleft()
        dist = visited[cur_x][cur_y][wall] + 1

        if [cur_x, cur_y] == [n - 1, m - 1]:
            return visited[cur_x][cur_y][wall]

        for x, y in dirs:
            next_x, next_y = cur_x + x, cur_y + y
            if visitable(next_x, next_y, wall):
                if not graph[next_x][next_y]:
                    visited[next_x][next_y][wall] = dist
                    q.append((next_x, next_y, wall))
                elif wall < k:
                    visited[next_x][next_y][wall + 1] = dist
                    q.append((next_x, next_y, wall + 1))

    return -1


if __name__ == '__main__':
    n, m, k = map(int, stdin.readline().split())
    graph = [list(map(int, stdin.readline().strip())) for _ in range(n)]
    visited = [[[0] * (k + 1) for _ in range(m)] for _ in range(n)]
    visited[0][0] = [1] * (k + 1)
    print(bfs((0, 0, 0)))
