package com.algo

class TwoPointers {
    fun solve(dim: Int, targetsum: Int, data: List<Int>): Int {
        var partialsum = 0
        var endpointer = 0
        var counter = 0
        for (startpointer in 0 until dim) {
            while (partialsum < targetsum && endpointer < dim) {
                partialsum += data[endpointer]
                endpointer++
            }
            if (partialsum == targetsum) {
                counter++
            }
            partialsum -= data[startpointer]
        }
        return counter
    }
}
