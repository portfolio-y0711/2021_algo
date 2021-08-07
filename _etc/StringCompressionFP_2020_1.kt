package com.algo

import kotlin.js.Math

class StringCompressionFP_2020_1 {
    fun solve(s: String): Int {
        val compressed = IntRange(1, Math.max(1, s.length / 2)).map {
            val result = compress(grouped(s, it))
            result
        }.minBy {
            it.length
        } ?: ""
        return compressed.length
    }

}

private fun compress(cs: MutableList<String>): String {
    return if (cs.isEmpty()) {
        ""
    } else {
        var head = cs[0];
        var reps = 0;
        for (s in cs) {
            if (s == head) reps++;
            else break;
        }
        if (reps == 1) {
            ""
        } else {
            "$reps"
        } + head + compress(cs.subList(reps, cs.size))
    }
}

private fun grouped(s: String, lengthOfRuler: Int): MutableList<String> =
        mutableListOf<String>().apply {
            (s.indices step lengthOfRuler).forEach { pos ->
                add(s.substring(pos, Math.min(pos + lengthOfRuler, s.length)))
            }
        }


