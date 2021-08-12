# https://www.acmicpc.net/problem/1655

# 수빈이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 수빈이가 정수를 하나씩 외칠때마다 동생은 지금까지 수빈이가 말한 수 중에서 중간값을 말해야 한다. 만약, 그동안 수빈이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.

# 예를 들어 수빈이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다. 수빈이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.


import heapq
import sys
input = sys.stdin.readline

N = int(input()) 
leftq, rightq = [], []
for _ in range(N):
    n = int(input())
    if len(leftq) == len(rightq):
        heapq.heappush(leftq, (-n, n))
    else:
        heapq.heappush(rightq, (n, n))
    if rightq and leftq[0][1] > rightq[0][1]:
        left, right = heapq.heappop(leftq)[1], heapq.heappop(rightq)[1]
        heapq.heappush(leftq, (-right, right))
        heapq.heappush(rightq, (left, left))
    print(leftq[0][1])
