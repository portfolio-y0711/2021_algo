# //https://www.acmicpc.net/problem/15650

#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
# 고른 수열은 오름차순이어야 한다.


n, m = map(int, input().split())

def solution(n, m):
    arr = [0] * m
    # visited = [False] * n

    def dfs(n, m, d):
        if d == m:
            return

        for i in range(0, n):
            if d > 0 and i < arr[d - 1]: 
                continue
            else:
                # visited[i] = True
                arr[d] = i + 1
                dfs(n, m, d + 1)
                # visited[i] = False
    dfs(n, m, 0)

solution(n, m)
