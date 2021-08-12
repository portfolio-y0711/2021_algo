#!/usr/bin/env python
# -*- coding: utf-8 -*-

# https://www.acmicpc.net/problem/15654

# N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

# N개의 자연수 중에서 M개를 고른 수열

n, m = map(int, input().split())

def solution(n, m): 
    visited = [False] * n
    arr = [0] * m

    def dfs(n, m, d):
        if d == m:
            print(arr)
            return

        for i in range(1, n + 1):
            if visited[i - 1] == True:
                continue

            visited[i - 1] = True
            arr[d] = i
            dfs(n, m, d + 1)
            visited[i - 1] = False


    dfs(n, m, 0)
    return

solution(n, m)
