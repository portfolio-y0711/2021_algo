import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] _M = Arrays.stream(br.readLine().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
    long M = _M[1];
    long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();

    long left = 0, right = Arrays.stream(trees).max().getAsLong();
    long mid, cut;
    
    while (left <= right) {
      mid = (left + right) / 2;
      cut = 0;

      for (long tree: trees) {
        if (tree > mid) {
          cut += (tree - mid);
        }
      }

      if (cut >= M) {
        left = mid + 1;
      } else {
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