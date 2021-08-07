// import java.util.Arrays;
// import java.util.List;
import java.util.Queue;
// import java.util.function.Supplier;
import java.util.LinkedList;
// import java.util.ArrayList;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    // ArrayList<Integer> list = (ArrayList<Integer>) IntStream
    //     .of(truck_weights)
    //     .boxed()
    //     .collect(Collectors.toCollection(ArrayList::new));

    // ArrayList<Integer> _list = Arrays
    //   .stream(truck_weights)
    //   .boxed()
    //   .collect(Collectors.toCollection(ArrayList::new));
  
    // 위의 두 가지 변환 방법 모두 컴파일러가 정확한 타입 정보를 추론하지 못함
    // truck_weights의 타입 정보가 stream 처리시 반영되지 않음
    // 자료형 선언/할당을 하지 않으면 타입 에러가 발생함(or 타입 캐스팅 필요함)

    // List<Integer> list = Arrays
    //   .stream(truck_weights)
    //   .boxed()
    //   .collect(Collectors.toList());

    // List<Integer> list = Arrays.stream(truck_weights)
    // .boxed()
    // .collect(Collectors.toList());

    // https://www.nextree.co.kr/p6506/
    // ArrayList 연속된 주소(배열과 유사)
    // LinkedList 포인터로 연결

    // Supplier<List<Integer>> supplier = () -> new LinkedList<Integer>();
    // Queue<Integer> truck_q = (LinkedList<Integer>) Arrays.stream(truck_weights)
    //   .boxed()
    //   .collect(Collectors.toCollection(supplier));
    

    int time = 0;
    Queue<Integer> trucks_on_brige = new LinkedList<>();

    int weightSum = 0;
    for (int w : truck_weights) {
      // System.out.println(String.format("truck: %s", w));
      while(true) {
        // producing
        if (trucks_on_brige.size() < bridge_length) {
          if (weightSum + w > weight) {
            trucks_on_brige.offer(0);
            // time++;
            // System.out.println(String.format("over loaded, weightSum + w: %s / time: %s / trucks on bridge: %s", weightSum + w, time, trucks_on_brige));
          } else {
            trucks_on_brige.offer(w);
            weightSum += w;
            // time++;
            // System.out.println(String.format("add truck, weightSum: %s / time: %s / trucks on bridge: %s", weightSum, time, trucks_on_brige));
            break;
          }
        // consuming
        } else {
          weightSum -= trucks_on_brige.poll();
          time++;
          // System.out.println(String.format("comsuming, weightSum: %s / time: %s / trucks on bridge: %s", weightSum, time, trucks_on_brige));
        }
      }
    }
    return bridge_length + time + bridge_length;
  }
}

class Truck {
  public static void main(String[] args) {
    System.out.println(
    new Solution()
      .solution(
        2, 
        10, 
        new int[]{ 7, 4, 5, 6 }
        )
    );
  }
}