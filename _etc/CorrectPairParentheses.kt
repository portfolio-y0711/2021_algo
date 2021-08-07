package com.algo

class CorrectPairParentheses {
    var pos = 0

    private fun isCorrect(paren: String): Boolean {
        var noOfLeftParen = 0
        var noOfRightParen = 0
        val parenstack = mutableListOf<Char>()
        var result = true
        for (i in 0..paren.size) {
            if (paren[i] == '(') {
                noOfLeftParen++
                parenstack.add('(')
                println("parenstack: $parenstack")
            } else {
                noOfRightParen++
                if (parenstack.isEmpty()) {
                    result = false
                    break
                } else {
                    parenstack.removeAt(parenstack.size - 1)
                }
            }
            if (noOfLeftParen == noOfRightParen) {
                pos += 1
                break
            }
        }
        return result
    }

    // paren = ")("
    fun recur(paren: String): String {
        // paren = ")("
        if (paren.isEmpty()) return paren
        var correct = isCorrect(paren)
        // correct = false
        // paren = ")("
        var u = paren.substring(0, pos)
        var v = paren.substring(pos, paren.size)
//        if (correct) {
//            return u + recur(v)
//        }

        // v = ")("
        var answer = "(" + recur(v) + ")"
//        for (i in 1 until v.size) {
//            answer +=
//                if (u[i] == '(') ')'
//                else '('
//        }
        return answer
    }
}
