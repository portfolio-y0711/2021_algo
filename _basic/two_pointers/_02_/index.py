# https://www.acmicpc.net/problem/1806

# 부분합 

# 시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
# 0.5 초 (하단 참고)	128 MB	34510	9054	6413	25.480%
# 문제
# 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

# 출력
# 첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.

# 예제 입력 1 
# 10 15
# 5 1 3 5 10 7 4 9 2 8
# 예제 출력 1 
# 2

import sys

def solution(s, arr):
  n = len(arr)
  sum = 0
  end = 0
  minlen = n + 1
  # minlen = sys.maxsize
  
  for start in range(n):
    while sum < s and end < n:
      sum += arr[end]
      end += 1
    if sum >= s: 
      minlen = min(minlen, end - start) 
      print(f'sum: {sum}, start: {start}, end: {end}, end - start: {end - start}')
    sum -= arr[start]

  if minlen == n + 1:
  # if minlen == sys.maxsize:
    print(0)
  else:
    print(minlen)

# solution(
#   15,
#   [
#     5,
#     1,
#     3,
#     5,
#     10,
#     7,
#     4,
#     9,
#     2,
#     8
#   ]
# )

if __name__ == "__main__":
  n, s = map(int, input().split())
  arr = list(map(int, input().split()))
  solution(s, arr)

    