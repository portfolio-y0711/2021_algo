package com.algo

class StringCompression_2020_1 {
    fun solution(s: String): Int {
        var final = s.length

        for (lenOfRuler in 1..s.length / 2) {
            var pos = 0
            var compressed = s.length

            while (pos + lenOfRuler <= s.length) {
                val ruler = s.substring(pos, pos + lenOfRuler)
                pos += lenOfRuler
                var cntOfPattern = 0

                while (pos + lenOfRuler <= s.length) {
                    if (ruler == s.substring(pos, pos + lenOfRuler)) {
                        cntOfPattern++
                        pos += lenOfRuler
                    } else {
                        break
                    }
                }
                if (cntOfPattern > 0) {
                    compressed -= lenOfRuler * cntOfPattern
                    compressed += when {
                        cntOfPattern <= 9 -> 1
                        cntOfPattern <= 99 -> 2
                        cntOfPattern <= 999 -> 3
                        else -> 4
                    }
                }
            }
            final = if (compressed < final) compressed else final
        }
        return final
    }
}
