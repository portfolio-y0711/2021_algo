import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
// import static java.util.Map.Entry;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
  public String solution(String[] participant, String[] completion) {
    Map<String, Long> map = Arrays
        .stream(participant)
        .collect(Collectors.groupingBy(p -> p, HashMap::new, Collectors.counting()));

    for (String comp: completion) {
      map.put(comp, map.get(comp) - 1);
    }

    return map.entrySet()
      .stream()
      .filter(e -> e.getValue() > 0)
      .findFirst().get().getKey();
  }
}

public class Marathon {
  public static void main(String[] args) {
    System.out.println(
    new Solution()
      .solution(
        new String[] {
          "leo", 
          "kiki", 
          "eden"
        },
        new String[] {
          "eden",
          "kiki" 
        }
      )
    );
  }
}