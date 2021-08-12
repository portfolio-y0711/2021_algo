// https://kotlinlang.org/docs/competitive-programming.html

import java.io.BufferedReader
/*https://www.acmicpc.net/problem/1302*/


class Solution {
  fun solution(): Unit {
    val n: Int = readLine()!!.toInt()
    val books: HashMap<String, Int> = HashMap()

    for (i: Int in 0 until n) {
      val title = readLine()!!
      if (!books.containsKey(title)) {
        books.put(title, 1)
      } else {
        books.put(title, books.get(title)!! + 1)
      }
    }

    val booklist = mutableListOf<String>()
    val max = books.values.max()

    for (key in books.keys) {
      if (books.get(key) == max) {
        booklist.add(key)
      }
    }
    val book = booklist.stream()
                .sorted()
                .findFirst()
                .get()
    println(book)
  }
}

fun main(args: Array<String>) {
  Solution() 
    .solution();
}