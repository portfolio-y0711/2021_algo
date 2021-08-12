#!/usr/bin/env python
# -*- coding: utf-8 -*-

# https://www.acmicpc.net/problem/15652

# 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

# 1부터 N까지 자연수 중에서 M개를 고른 수열
# 같은 수를 여러 번 골라도 된다.
# 고른 수열은 비내림차순이어야 한다.
# 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

n,m = map(int, input().split())

def solution(n, m):
    arr = [0] * m
    # visited = [False] * n + 1

    def dfs(n, m, d) : 
        if (d == m):
            print(arr)
            return

        for i in range(1, n + 1):
            if d > 0 and i < arr[d - 1]: 
                continue
            # visited[i] = True
            arr[d] = i
            dfs(n, m, d + 1)
            # visited[i] = False
    dfs(n, m, 0)

solution(n, m)

    


