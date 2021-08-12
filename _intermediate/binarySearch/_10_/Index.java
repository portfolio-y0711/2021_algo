import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Integer _num = 
    Integer.parseInt(br.readLine());
    int[] numbers = Arrays
      .stream(br.readLine().split(" "))
      .mapToInt(s -> Integer.parseInt(s))
      .sorted()
      .toArray();

      // System.out.println(Arrays.stream(numbers).boxed().collect(Collectors.toList()));

    // Integer _fnum = 
    Integer.parseInt(br.readLine());
    int[] fnumbers = Arrays
      .stream(br.readLine().split(" "))
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();

      // System.out.println(Arrays.stream(fnumbers).boxed().collect(Collectors.toList()));
    
    int mid;
    int left;
    int right;
    boolean found;

    for (int f: fnumbers) {
      left = 0;
      right = numbers.length - 1;
      found = false;

      while (left <= right) {
        mid = (left + right) / 2;
        if (f == numbers[mid]) {
          found = true;
          break;
        } else if (f > numbers[mid]) {
          left = mid + 1;
        } else if (f < numbers[mid]) {
          right = mid - 1;
        }
      }
      if (!found) {
        System.out.println(0);
      } else {
        System.out.println(1);
      }
    }
  }

}

public class Index {
  public static void main(String[] args) throws IOException {
    new Solution()
      .solution();
  }
}
