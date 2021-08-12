import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//https://www.acmicpc.net/problem/1302

//김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

//오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

class Solution {
  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    HashMap<String, Integer> books = new HashMap<String, Integer>();

    for (int i = 0; i < n; i++) {
      String title = br.readLine();
      if (!books.containsKey(title)) {
        books.put(title, 1);
      } else {
        books.put(title, books.get(title) + 1);
      }
    }

    List<String> booklist = new LinkedList();
    int max = Collections.max(books.values());
    for (String key: books.keySet()) {
      if (books.get(key) == max) {
        booklist.add(key);
      }
    }
    String book = booklist.stream().sorted().findFirst().get();
    bw.write(book);
    bw.flush();
  }
}

public class Index {
  public static void main(String[] args) throws Exception {
    new Solution().solution();
  }

}