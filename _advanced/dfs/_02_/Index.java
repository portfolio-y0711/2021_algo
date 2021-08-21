
// https://www.acmicpc.net/problem/2178

// N×M크기의 배열로 표현되는 미로가 있다.

// 1	0	1	1	1	1
// 1	0	1	0	1	0
// 1	0	1	0	1	1
// 1	1	1	0	1	1
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

// 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

// 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

// 4 6
// 101111
// 101010
// 101011
// 111011

// 15

// 4 6
// 110110
// 110110
// 111111
// 111101

// 9

// 2 25
// 1011101110111011101110111
// 1110111011101110111011101

// 38

// 7 7
// 1011111
// 1110001
// 1000001
// 1000001
// 1000001
// 1000001
// 1111111

// 13

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Index {
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };
  static int[][] maze;
  static boolean[][] visited;
  static int N, M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maze = new int[N][M];
    visited = new boolean[maze.length][maze[0].length];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int j = 0; j < M; j++) {
        maze[i][j] = line.charAt(j) - '0';
      }
    }

    bfs(0, 0);
    System.out.println(maze[maze.length - 1][maze[0].length - 1]);

  }

  public static void bfs(int i, int j) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { i, j });
    int[] node;

    while (!q.isEmpty()) {
      node = q.poll();

      for (int d = 0; d < 4; d++) {
        int x = node[0] + dx[d];
        int y = node[1] + dy[d];

        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length) {
          if (maze[x][y] != 0 && !visited[x][y]) {
            q.offer(new int[] { x, y });
            visited[x][y] = true;
            maze[x][y] = maze[node[0]][node[1]] + 1;
            }
          }
        }
      }
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class Baekjoon2178_MazeSearch {

// static int[] dr = {1,-1,0,0};
// static int[] dc = {0,0,-1,1};
// static boolean[][] visited;
// static int[][] map;
// static int N,M;

// public static void main(String args[]) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());

// N = Integer.parseInt(st.nextToken());
// M = Integer.parseInt(st.nextToken());

// map = new int[N][M];
// visited = new boolean[N][M];

// for (int i = 0; i < N; i++) {
// st = new StringTokenizer(br.readLine());
// String line = st.nextToken();
// for (int j = 0; j < M; j++) {
// map[i][j] = line.charAt(j) - '0';
// }
// }

// bfs(0,0);

// System.out.println(map[N-1][M-1]);
// }

// public static void bfs(int i, int j){
// Queue<int[]> q = new LinkedList<>();
// q.offer(new int[] {i,j});

// while(!q.isEmpty()){
// int location[] = q.poll();
// visited[i][j] = true;

// for(int dir = 0; dir<4; dir++){
// int r = location[0] + dr[dir];
// int c = location[1] + dc[dir];

// //좌표가 -1이 되거나 N or M이 되어 map의 범위를 벗어나면 안되므로
// if(r >= 0 && c >= 0 && r < N && c < M){
// if(map[r][c] != 0 && !visited[r][c]){
// q.offer(new int[] {r,c});
// visited[r][c] = true;
// map[r][c] = map[location[0]][location[1]] + 1;
// }
// }
// }
// }
// }
// }
