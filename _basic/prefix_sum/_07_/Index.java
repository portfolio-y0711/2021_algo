https://www.acmicpc.net/problem/1687

행렬 찾기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	336	123	97	37.308%
문제
0과 1로 이루어진 행렬이 있다. 이 행렬의 부분행렬은 이 행렬 안에 포함되는 행렬을 의미한다. 이러한 부분행렬들 중에서 0으로만 이루어진 부분행렬을 찾으려 한다. 그 중에서 가장 면적이 넓은 것을 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 행렬의 크기를 나타내는 두 정수 N, M(1≤N, M≤333)이 주어진다. 다음 N개의 줄에는 M개의 정수(0또는 1)가 공백없이 주어진다. 이 숫자는 행렬을 구성하는 원소이다.

출력
첫째 줄에 답을 출력한다.

예제 입력 1 
3 3
000
001
100
예제 출력 1 
4
