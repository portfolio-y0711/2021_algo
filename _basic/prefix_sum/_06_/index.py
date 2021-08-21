# https://www.acmicpc.net/problem/1749

# 점수따먹기
# 시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
# 2 초	128 MB	459	149	109	30.966%
# 문제
# 동주는 항상 혼자 노느라 심심하다. 하지만 혼자 놀기의 고수가 된 동주는 매일매일 게임을 개발하여 혼자놀기의 진수를 우리에게 보여준다. 어느 날 동주는 새로운 게임을 개발하였다. 바로 점수 따먹기라는 게임인데 그다지 재밌어 보이지는 않는다.

# 동주가 개발한 게임은 이렇다. 일단 N*M 행렬을 그린 다음, 각 칸에 -10,000 이상 10,000 이하의 정수를 하나씩 쓴다. 그런 다음 그 행렬의 부분행렬을 그려 그 안에 적힌 정수의 합을 구하는 게임이다.

# 동주가 혼자 재밌게 놀던 중 지나가는 당신을 보고 당신을 붙잡고 게임을 하자고 한다. 귀찮은 당신은 정수의 합이 최대가 되는 부분행렬을 구하여 빨리 동주에게서 벗어나고 싶다.

# 입력
# 첫째 줄에 N (1 < N < 200), M (1 < M < 200)이 주어진다. 그 다음 N개의 줄에 M개씩 행렬의 원소가 주어진다.

# 출력
# 첫째 줄에 최대의 합을 출력하라.

# 예제 입력 1
# 3 5
# 2 3 -21 -22 -23
# 5 6 -22 -23 -25
# -22 -23 4 10 2
# 예제 출력 1
# 16


import sys
input = sys.stdin.readline
N, M = map(int, input().split())
nums = [list(map(int, input().split())) for _ in range(N)]

# 일반식을 통한 prefix_sum 채우기
prefix_sum = [[0] * (M + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, M + 1):
        prefix_sum[i][j] = prefix_sum[i - 1][j] + prefix_sum[i][j - 1] + nums[i - 1][j - 1] - prefix_sum[i - 1][j - 1]

# ans의 최솟값은 200x200칸에 모두 -10000이 들어 있는 경우인 -4억이다
# x1, y1, x2, y2를 증가시켜가며 4중 for문으로 완전탐색
# 부분행렬 구하는 것도 공식을 통해..
ans = -400000001
for x1 in range(1, N+1):
    for y1 in range(1, M+1):
        for x2 in range(x1, N+1):
            for y2 in range(y1, M+1):
                ans = max(ans, prefix_sum[x2][y2] - prefix_sum[x2][y1 - 1] -
                          prefix_sum[x1 - 1][y2] + prefix_sum[x1 - 1][y1 - 1])
print(ans)
