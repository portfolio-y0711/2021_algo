import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int KN[] = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
    int K = KN[0];
    int N = KN[1];

    int[] codes = new int[K];
    for (int i = 0; i < K; i++) {
      codes[i] = Integer.parseInt(br.readLine());
    }

    long left = 1;
    long right = Arrays.stream(codes).max().getAsInt();
    long mid;
    long lines;

    while (left <= right) {
      lines = 0;
      mid = (left + right) / 2;

      for (long code: codes) {
        lines += (code / mid);
      }

      if (lines >= N) {
        left = mid + 1;
      } else if (lines < N) {
        right = mid - 1;
      }
    }
    System.out.println(right);
  }
}

public class Index {
  public static void main(String[] args) throws Exception {
    new Solution()
      .solution();
  }
}