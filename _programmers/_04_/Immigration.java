import java.util.Arrays;
// import java.util.stream.Collectors;


class Solution {
  public long solution(int n, int[] times) {
    long left = 0;
    // int upperBound = Arrays.stream(times).max().getAsInt() * n;
    Arrays.sort(times);
    long right = (long) n * times[times.length - 1];
    long mid = 0;
    long count;
    while (left < right) {
      mid = (left + right) / 2;
      count = 0;
      for (int time: times) {
        System.out.println(time);
        count += (mid / time);
      }
      if (count >= n) {
        right = mid;
      } else {
        left = mid + 1;
      }
      System.out.println(String.format("mid: %s, count: %s", mid, count));
      System.out.println(String.format("left: %s, right: %s", left, right));
    }
    return (long) mid;
  }
}

class Immigration {
  public static void main(String[] args) {
    System.out.println(
    new Solution()
      .solution(6, new int[] { 7, 10 })
    );
  }
}