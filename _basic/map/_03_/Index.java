import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.*;
import java.util.*;

// https://www.acmicpc.net/problem/1920

// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.


class Solution {
  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int _N = Integer.parseInt(br.readLine());

    Map<String, Integer> map = (HashMap<String, Integer>) Arrays.stream(
      br.readLine().split(" ")
    ).collect(Collectors.toMap(s -> s, s -> 1));

    int _M = Integer.parseInt(br.readLine());
    for (String s: br.readLine().split(" ")) {
      System.out.println(
        map.getOrDefault(s, 0)
      );
    }

    // int[] a = Arrays.stream(
    //   br.readLine().split(" ")
    // ).mapToInt(s -> Integer.parseInt(s))
    // .toArray();

    // int M = Integer.parseInt(br.readLine());

    // int[] b = Arrays.stream(
    //   br.readLine().split(" ")
    // ).mapToInt(s -> Integer.parseInt(s))
    // .toArray();

  }
}

public class Index {
  public static void main(String[] args) throws Exception {
    new Solution()
      .solution();
  }
}