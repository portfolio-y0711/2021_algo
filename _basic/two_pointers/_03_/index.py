# https://www.acmicpc.net/problem/2230

# 수 고르기
# 시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
# 2 초	128 MB	5065	1580	1123	28.568%

# 문제
# N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

# 예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다. 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

# 입력
# 첫째 줄에 두 정수 N, M이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.

# 출력
# 첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.

# 제한
# 1 ≤ N ≤ 100,000
# 0 ≤ M ≤ 2,000,000,000
# 0 ≤ |A[i]| ≤ 1,000,000,000
# 예제 입력 1 
# 3 3
# 1
# 5
# 3
# 예제 출력 1 
# 4
import sys

def solution(m, arr):
  n = len(arr)
  arr.sort()
  # diff = 0
  min_diff = sys.maxsize
  start = 0
  end = 0

  # print(f'start: {start}, end: {end}')
  # print(f'start: {start}, end: {end}, arr[start]: {arr[start]}, arr[end]: {arr[end]}')
  while start <= end and start < n and end < n  - 1 :
    if arr[end] - arr[start] < m:
      end += 1
    else: 
      start += 1

    if arr[end] - arr[start] >=  m:
      min_diff = min(arr[end] - arr[start], min_diff)

  # for start in range(n):
  #   while diff < m and end < n: 
  #     # print(f'start: {start}, end: {end}')
  #     diff = arr[end] - arr[start]
  #     # print(f'start: {start}, end: {end}, arr[start]: {arr[start]}, arr[end]: {arr[end]}, diff: {diff}, ')
  #     end += 1

  #   if diff == m:
  #     print(diff)
  #     exit(0)

  #   if diff > m:
  #     min_diff = min(min_diff, diff)

  #   diff = 0

  print(min_diff)

# solution(
#   3,
#   [
#     1,
#     5,
#     3
#   ]
# )

if __name__ == "__main__":
  n, m = map(int, sys.stdin.readline().split())

  arr = [0] * n
  for i in range(n):
    arr[i] = int(sys.stdin.readline())

  solution(m, arr)