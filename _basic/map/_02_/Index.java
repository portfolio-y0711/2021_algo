import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public char solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int[] ascii = new int[26];
    
    for (int i = 0; i < str.length(); i++) {
      int idx;
      if (str.charAt(i) - 65 < 26) {
        idx = str.charAt(i) - 65;
      } else {
        idx = str.charAt(i) - 97;

      }
      ascii[idx]++;
    }

    int max = -1;
    char answer = '0';

    for (int i = 0; i < ascii.length; i++) {
      if (ascii[i] == 0) continue;
      if (max < ascii[i]) {
        max = ascii[i];
        answer = (char) (i + 65);
      } else {
        if (max == ascii[i])  {
          answer = '?';
        }
      }
    }
    return answer;
  }
}

class Index {
  public static void main(String[] args) throws IOException {
    System.out.println(
      new Solution()   
        .solution()
    );
  }
}