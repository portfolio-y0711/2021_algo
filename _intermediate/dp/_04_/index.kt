// https://www.acmicpc.net/problem/2579

// 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.



// 10 20 15 25 10 20

// <그림 1>

// 예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.


// <그림 2>

// 계단 오르는 데는 다음과 같은 규칙이 있다.

// 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
// 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
// 마지막 도착 계단은 반드시 밟아야 한다.
// 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

// 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

import java.util.Arrays;

fun main(args: Array<String>) {
 class Solution {
  fun solution(_stairs: IntArray, n: Int): Int {
    if (n == 1) {
      return _stairs[0]
    } else {
      val dp = IntArray(n + 1) { 0 }
      val stairs = (sequenceOf<Int>(0) + _stairs.asSequence()).toIntArray(n + 1)

      dp[1] = stairs[1]
      dp[2] = stairs[1] + stairs[2]

      for (i in 3 until (n + 1)) {
        dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2] + stairs[i])
      }
      return dp[n]
    }


    
  }
 } 
 println(
   Solution()
    .solution(
      intArrayOf(
        10, 
        20,
        15,
        25,
        10,
        20
        ),
        6
    )
 )
}

fun Sequence<Int>.toIntArray(size: Int): IntArray {
  val iter = iterator()
  return IntArray(size) { iter.next() }
}
