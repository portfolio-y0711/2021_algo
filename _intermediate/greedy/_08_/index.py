# https://www.acmicpc.net/problem/1931

# 회의실 배정
# 시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
# 2 초	128 MB	88219	26348	18960	28.946%
# 문제
# 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

# 입력
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

# 출력
# 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

# 예제 입력 1 
# 11
# 1 4
# 3 5
# 0 6
# 5 7
# 3 8
# 5 9
# 6 10
# 8 11
# 8 12
# 2 13
# 12 14
# 예제 출력 1 
# 4
# https://www.acmicpc.net/problem/1931

# 회의실 배정
# 시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
# 2 초	128 MB	88219	26348	18960	28.946%
# 문제
# 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

# 입력
# 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

# 출력
# 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

# 예제 입력 1 
# 11
# 1 4
# 3 5
# 0 6
# 5 7
# 3 8
# 5 9
# 6 10
# 8 11
# 8 12
# 2 13
# 12 14
# 예제 출력 1 
# 4


# n = int(input())
# s = []
# for i in range(n):
#     first, second = map(int, input().split())
#     s.append([first, second])
# s = sorted(s, key=lambda a: a[0])
# s = sorted(s, key=lambda a: a[1])
# last = 0
# cnt = 0
# for i, j in s:
#     if i >= last:
#         cnt += 1
#         last = j
# print(cnt)


# import sys

# N = int(sys.stdin.readline())

# time = [[0]*2 for _ in range(N)]
# for i in range(N):
#     s, e = map(int, sys.stdin.readline().split())
#     time[i][0] = s
#     time[i][1] = e

# time.sort(key = lambda x: (x[1], x[0]))

# cnt = 1
# end_time = time[0][1]
# for i in range(1, N):
#     if time[i][0] >= end_time:
#         cnt += 1
#         end_time = time[i][1]

# print(cnt)


# import sys

# N = int(input())
# meeting = []
# for _ in range(N):
#     meeting.append(list(map(int, sys.stdin.readline().split())))

# meeting = sorted(meeting, key = lambda x: [x[1], x[0]])


# #빨리 끝나는 것 중 가장 빨리 시작하는 순서대로 더해준다.
# max_meeting = 0
# start = 0
# for meet in meeting:
#     if meet[0] >= start:
#         start = meet[1]
#         max_meeting += 1
        
# print(max_meeting)
