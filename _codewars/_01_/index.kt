import kotlin.ranges.IntRange
import kotlin.math.pow

fun main(args: Array<String>) {
  fun nbDig(n: Int, d: Int): Int {
    val m = IntRange(0, n)
      .map { 
        e ->
        val isContain = (e * e)
          .toString()
          .split("")
          .contains(d.toString())
        println("e: $e, d: ${d.toString()}, isContain: $isContain") ;
        isContain
       }
       .count { b -> b == true }
    return m
  }
  println(
    // nbDig(n = 10, d = 1)
    nbDig(n = 100, d = 0)
  )
}

