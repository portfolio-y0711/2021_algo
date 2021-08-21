# https://www.acmicpc.net/problem/11000

# 수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. 

# 김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 

# 참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)

# 수강신청 대충한 게 찔리면, 선생님을 도와드리자!

# 첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)

# 이후 N개의 줄에 Si, Ti가 주어진다. (1 ≤ Si < Ti ≤ 109)

# 강의실의 개수를 출력하라.

# 3
# 1 3
# 2 4
# 3 5

# 2

# 이 문제에서 중요하게 생각해야 할 부분은,
# 현재 회의실의 종료시간과 다음 열릴 회의의 시작시간 과의 관계이다.

# ① 현재 회의실에서의 회의가 끝나는 시간보다 다음 회의의 시작시간이 빠르면
# 회의실을 하나 추가로 개설한다.

# ② 현재 회의실에서 회의가 끝나는 시간보다 다음 회의의 시작시간이 느리면
# 현재 존재하는 회의실에서 이어서 회의 개최가 가능하다.

# 이 두가지를 고려하면 된다.

# 먼저, 회의의 [시작, 끝] 시간을 세트로 하나의 리스트에 모두 입력받는다.
# 그리고 시작시간을 기준으로 정렬을 먼저 해준다. 그럼 시작시간이 빠른 순서대로 앞에 오게 된다.

# 그리고 첫 회의의 종료시간을 새로운 큐(room)에 먼저 넣어준다.
# 그럼 두 번째 회의부터 첫 회의와 비교를 하게 될텐데,

# 두 번째 회의의 시작시간이 첫 회의의 종료시간보다 빠르면 새로 회의실을 개최해야 하고
# 아니면, 기존 회의실을 사용하면 된다.

# 밑의 코드에서 기존 회의실을 사용하는 코드는 room에서 한번 pop을 해주고 새로운 회의시간을 push 해주는 것이다.
# 새로 회의실을 개설해야 하면, room에 새로운 회의의 종료시간을 push 해주면 된다.

# 단, 이 때 종료시간이 빠른 회의실부터 다음 회의를 이어서 개최해야 하기 때문에
# 우선순위 큐를 이용해 큐에 push를 해주어 큐가 정렬상태를 유지할 수 있도록 해준다.


# import heapq
# n = int(input())

# q = []

# for i in range(n):
#     start, end = map(int, input().split())
#     q.append([start, end])

# q.sort()

# room = []
# heapq.heappush(room, q[0][1])

# for i in range(1, n):
#     if q[i][0] < room[0]: # 현재 회의실 끝나는 시간보다 다음 회의 시작시간이 빠르면
#         heapq.heappush(room, q[i][1]) # 새로운 회의실 개설
#     else: # 현재 회의실에 이어서 회의 개최 가능
#         heapq.heappop(room) # 새로운 회의로 시간 변경을 위해 pop후 새 시간 push
#         heapq.heappush(room, q[i][1])

# print(len(room))


# 최소한의 강의실을 사용하여 모든 수업을 해야 한다.
# 빠지는 수업이 있으면 안되므로 입력받은 수업을 시작하는 시간 기준으로 오름차순 정렬한다.
# 이 문제는 heapq를 이용하여 해결할 수 있는데 반복문을 순회하며 새로운 수업을 검사할 때
# 이전 수업 시간의 끝나는 시간 중 가장 빨리 끝나는 시간과 비교하면 되기 때문이다.
# 따라서 우선 제일 일찍 시작하는 수업의 끝나는 시간을 nheaps에 저장한다.
# 그리고 수업 리스트를 인덱스 1부터 시작하여 시작하는 시간과
# nheaps에 있는 가장 빨리 끝나는 시간 (nheaps[0])을 비교하여 끝나는 시간이 새로운 수업의 시작하는 시간보다
# 같거나 작은 경우 기존의 끝나는 시간을 pop해서 제거하고 새 수업의 끝나는 시간을 push한다.
# 그렇지 않은 경우는 새로운 강의실을 써야 하므로 새로운 수업의 끝나는 시간을 그대로 push한다.
# 반복문이 끝나고 nheaps의 길이가 필요한 총 강의실 갯수 이다.

# import sys
# import heapq
# n = int(sys.stdin.readline().rstrip("\n"))
# classes = []
# for i in range(n):
#     classes.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))
# classes = sorted(classes, key=lambda x:x[0])
# nheapps = []
# heapq.heapify(nheapps)
# heapq.heappush(nheapps, classes[0][1])

# for i in range(1,n):
#     if(nheapps[0] <= classes[i][0]):
#         heapq.heappop(nheapps)
#         heapq.heappush(nheapps,classes[i][1])
#     else:
#         heapq.heappush(nheapps,classes[i][1])

# print(len(nheapps))

