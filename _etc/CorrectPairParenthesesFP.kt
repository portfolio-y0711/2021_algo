package com.algo

class CorrectPairParenthesesFP {
    fun isBalanced(s: String): Boolean {
        return s.asIterable()
                .toList()
                .filter { c -> c == '(' }
                .count() ==
                s.asIterable()
                        .toList()
                        .filter { c -> c == ')' }.count()
    }

    fun isRight(s: String): Boolean =
            (s.asIterable()
                    .toList()
                    .fold(0) { acc, curr ->
                        if (curr == '(' && acc >= 0) {
                            acc + 1
                        } else {
                            acc - 1
                        }
                    }) == 0

    fun split(s: String): List<String> {
        var pos = 0
        val result: List<String> by lazy {
            for (i in 0 until s.size) {
                if (isBalanced(s.substring(0, i + 1))) {
//                    println("i: $i")
//                    println("u : ${s.substring(0, i + 1)}")
//                    println("v : ${s.substring(i + 1)}")
                    pos = i + 1
//                    println("pos u : ${s.substring(0, pos)}")
//                    println("pos v : ${s.substring(pos)}")
                    break
                }
            }
            listOf(s.substring(0, pos), s.substring(pos))
        }
        return result
    }

    fun trimReverse(s: String): String {
        return s.substring(1, s.size - 1)
            .replace('(', 'T')
            .replace(')', '(')
            .replace('T', ')');
    }

    fun correctParen(s: String): String {
//        println(s)
        if (isRight(s)) {
            return s
        }
        else {
            val (u, v) = split(s)
            println("u: $u")
            println("v: $v")
            if (isRight(u))
                return u + correctParen(v);
            else
                return "(" + correctParen(v) + ")" + trimReverse(u);
        }
    }

    fun solve(s: String): String {
        return correctParen(s)
    }

}
