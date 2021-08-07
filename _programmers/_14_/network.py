#!/usr/bin/env python
# -*- coding: utf-8 -*-

def dfs(n, computers, visited, start):
  stack = [start]
  while stack:
    j = stack.pop()
    if visited[j] == 0:
      visited[j] = 1
    for i in range(n):
      if computers[j][i] == 1 and visited[i] == 0:
        stack.append(i)
  return

def solution(n, computers):
  answer = 0
  visited = [0] * n

  for i in range(n):
    if not visited[i]:
      dfs(n, computers, visited, i)
      answer += 1
  return answer

print(
  solution(
    3, 
    [
      [1, 1, 0], 
      [1, 1, 0], 
      [0, 0, 1]
    ]	
  )
)