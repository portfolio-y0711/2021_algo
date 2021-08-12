# https://www.acmicpc.net/problem/1920

# N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

# 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
# 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
# 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
# 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
# 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

def solution():
  num = int(input())
  numbers = list(map(int, input().split()))
  numbers.sort()

  fnum = int(input())
  fnumbers = list(map(int, input().split()))

  for f in fnumbers:
    left, right = 0, len(numbers) - 1
    found = False

    while left <= right:
      mid = (left + right) // 2
      if (f == numbers[mid]):
        found = True
        break
      elif f > numbers[mid]:
        left = mid + 1
      elif f < numbers[mid]:
        right = mid - 1

    if not found:
      print(0)
    else :
      print(1)
