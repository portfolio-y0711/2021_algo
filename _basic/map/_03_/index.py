# https://www.acmicpc.net/problem/1920

# N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.


# 해시맵
N, A = int(input()), { i: 1 for i in map(int, input().split()) }
print(A)
M = input()
for i in map(int, input().split()):
    print(A.get(i, 0))

# 이분탐색
# input_num = int(input())
# numbers = list(map(int, input().split()))
# numbers.sort()

# input_num2 = int(input())
# numbers2 = list(map(int, input().split()))

# for num in numbers2:
#     left, right = 0, len(numbers) - 1
    
#     is_find = False
    
#     while True:
#         median = (left + right) // 2
#         if num == numbers[median]:
#             print(1)
#             is_find = True
#             break
#         elif num > numbers[median]:
#             left = median + 1
#         elif num < numbers[median]:
#             right = median - 1
            
#         if left > right:
#             break
            
#     if not is_find:
#         print(0)


# 출처: https://somjang.tistory.com/entry/BaekJoon-1920번-수-찾기-Python [솜씨좋은장씨]
