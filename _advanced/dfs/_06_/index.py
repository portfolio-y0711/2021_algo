# https://www.acmicpc.net/problem/16946

# N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 한 칸에서 다른 칸으로 이동하려면, 두 칸이 인접해야 한다. 두 칸이 변을 공유할 때, 인접하다고 한다.

# 각각의 벽에 대해서 다음을 구해보려고 한다.

# 벽을 부수고 이동할 수 있는 곳으로 변경한다.
# 그 위치에서 이동할 수 있는 칸의 개수를 세어본다.
# 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

# 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.

# 맵의 형태로 정답을 출력한다. 원래 빈 칸인 곳은 0을 출력하고, 벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.

# 3 3
# 101
# 010
# 101

# 303
# 050
# 303

# 4 5
# 11001
# 00111
# 01010
# 10101

# 46003
# 00732
# 06040
# 50403

# 문제를 꼼꼼히 읽자...ㅎㅎ 처음에는 무작정 BFS로 짰다가 계속 시간초과가 나길래 (구글의 도움을 빌려서) 코드를 수정했다. 찾아보기로는 플러드 필이라는 알고리즘 구현을 요구하는 문제라고 한다. 처음 듣는 알고리즘이라 해당 알고리즘에 대해서는 나중에 별도로 정리해봐야겠다.

# 1. 인접해 있는 0을 묶어서 그룹 인덱스를 붙임

# 2. 해당 그룹에 0이 총 몇 개가 포함되어있는지를 저장하는 딕셔너리 생성

# 3. 보드를 돌 때마다 1을 만나면 상하좌우 그룹의 0 개수를 전부 더해서 출력(2번의 딕셔너리 이용)



# import sys
# from collections import deque

# r, c = map(int, sys.stdin.readline().rsplit())
# visited = [[False for _ in range(c)] for _ in range(r)]
# arr = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(r)]
# answer = [[0 for _ in range(c)] for _ in range(r)]
# d = ((0,1), (0,-1), (1,0), (-1,0))

# for i in range(r):
#     for j in range(c):
#         if arr[i][j] == 1: answer[i][j] = 1

# def bfs(sy, sx):
#     q = deque()
#     q.append((sy, sx))
#     cnt = 1
#     ones = []

#     while q:
#         y, x = q.popleft()

#         for i in range(4):
#             ny = y + d[i][0]
#             nx = x + d[i][1]

#             if -1<ny<r and -1<nx<c:
#                 if visited[ny][nx]: continue
#                 visited[ny][nx] = True

#                 if arr[ny][nx] == 0:                  
#                     visited[ny][nx] = True
#                     q.append((ny,nx))
#                     cnt += 1

#                 else: ones.append((ny, nx))
    
#     for y, x in ones:
#         visited[y][x] = False
#         answer[y][x] += cnt
#         if answer[y][x] >= 10: answer[y][x] %= 10

# for i in range(r):
#     for j in range(c):
#         if arr[i][j] == 0:
#             if not visited[i][j]:
#                 visited[i][j] = True
#                 bfs(i,j)

# for i in range(r):
#     print(''.join(map(str,answer[i])))
