// https://programmers.co.kr/learn/courses/30/lessons/72411?language=kotlin

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Solution {
    public void comb(char[] arr, ArrayList<char[]> set, ArrayList<Character> visited, int start, int n, int r) {
      char[] snapshot;
      if (r == 0) {
        snapshot = new char[visited.size()];
        for (int i = 0; i < visited.size(); i++) {
          snapshot[i] = visited.get(i);
        }
        set.add(snapshot);
        return;
      }
      for (int i = start; i < n; i++) {
        visited.add(arr[i]);
        comb(arr, set, visited, i + 1, n, r - 1);
        visited.remove(visited.size() - 1);
      }
    }

    public String[] solution(String[] orders, int[] course) {
      ArrayList<char[]> set = new ArrayList<char[]>();
      List<List<String>> setOfString = new ArrayList<List<String>>();
      List<String> listOfString;

      for (int c: course) {
        for (String order: orders) {
          comb(order.toCharArray(), set, new ArrayList<Character>(), 0, order.length(), 2);
          listOfString = set.stream()
            .map(ca -> {
              return String.valueOf(ca);
            })
            .collect(Collectors.toList());
          setOfString.add(listOfString);
        }
        comb(orders[0].toCharArray(), set, new ArrayList<Character>(), 0, 5, c);

        Map<String, Long> stringMap = setOfString
          .stream()
          .flatMap(x -> x.stream())
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(stringMap);
        Long max = stringMap
          .entrySet()
          .stream()
          .max(Map.Entry.comparingByValue())
          .get()
          .getValue();

          System.out.println(
        stringMap
          .entrySet()
          .stream()
          .filter(e -> e.getValue() == max)
          .map(e -> e.getKey())
          .collect(Collectors.toList())
        );
      }


       
      // List<String> list = new ArrayList<>();
      // list.add("Hello");
      // list.add("Hello");
      // list.add("World");
      // Map<String, Long> counted = list.stream()
      //     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      // System.out.println(counted);


      // List<String> listOfString = set.stream()
      //   .map(ca -> {
      //     return String.valueOf(ca);
      //    })
      //   .collect(Collectors.toList());
      
      // System.out.println(listOfString);


      String[] answer = {};
      return answer;
    }
}

class Menu {
  public static void main(String[] args) {
    // ArrayList<ArrayList<String>> set = new ArrayList();
    // new Solution()
    //   .comb(
    //     new String[]{ "a", "b", "c", "d" }, 
    //     set, 
    //     new ArrayList<String>(), 
    //     0, 
    //     4, 
    //     2
    //   );
    // System.out.println(set);
    
    // System.out.println(
      new Solution()
        .solution(
          new String[]{
            "ABCFG", 
            "AC", 
            "CDE", 
            "ACDE", 
            "BCFG", 
            "ACDEH"
          },
          new int[]{
            2, 3, 4
          }
        );
    // );
  }

}

