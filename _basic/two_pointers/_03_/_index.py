
import sys

def check(arr, m, n):
    start, end = 0, 1
    answer = 2e9 + 1
    while end < n:
        if arr[end] - arr[start] < m:
            end += 1
            continue
        if arr[end] - arr[start] == m:
            return m
        
        answer = min(answer, arr[end] - arr[start])
        start += 1
    return answer

n, m = list(map(int, sys.stdin.readline().split()))
arr = [0] * n

for i in range(n):
    arr[i] = int(sys.stdin.readline())
        
answer = check(sorted(arr), m, n)
print(answer)
        
        
        