import java.util.ArrayList;


class Solution {
  public int solution(int[] stats) {
    ArrayList<Integer> teams = new ArrayList<>();

    for (int i: stats) {
     if (teams.size() == 0)  {
      teams.add(i);
     } else {
       boolean joined = false;
       for (int j = 0; j < teams.size(); j++) {
        if (i > teams.get(j)) {
          teams.set(j, i);
          joined = true;
          break;
        }
       }
       if (!joined) {
         teams.add(i);
       }
     }
    }
    return teams.size();
  }
}


public class Index {
  public static void main(String[] args) {
    System.out.println(
      new Solution() 
        .solution(
          new int[] {
            6,
            2,
            3,
            4,
            1,
            5
          }
        )
    );
  }
};
