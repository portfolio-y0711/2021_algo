
# https://www.acmicpc.net/problem/1927

# 널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

# 배열에 자연수 x를 넣는다.
# 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
# 프로그램은 처음에 비어있는 배열에서 시작하게 된다.


from queue import PriorityQueue
import sys
input = sys.stdin.readline

q = PriorityQueue()
n = int(input())

for i in range(n):
    now = int(input())
    if now != 0:
        q.put(now)
    else:
        if q.empty():
            print(0)
        else:
            print(q.get())
