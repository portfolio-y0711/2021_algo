import java.io.*;
import java.util.*;

class Solution {
  public int solution(int m, int[] list) {
      int n = list.length;
      int start = 0, end = 0;
      int min = 2100000000;

      while (start <= end && start < n && end < n - 1) {
        if (list[end] - list[start] < m) {
          end++;
        } else {
          start++;
        }
        if (list[end] - list[start] >= m) {
          min = Math.min(list[end] - list[start], min);
        }
      }
      return min;
  }
}

public class Index {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // ArrayList<Integer> list = new ArrayList<>();
        int[] list = new int[n];

        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
            // list.add(Integer.parseInt(br.readLine()));
        Arrays.sort(list);
        // Collections.sort(list);
        int min = new Solution()
          .solution(m, list);

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
