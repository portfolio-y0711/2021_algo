package com.algo

class PrefixSum(private val data: List<Int>) {
    private val prefixsum = mutableListOf<Int>(0)
    init {
        var sum = 0
        for (d in data) {
            sum += d
            prefixsum.add(sum)
        }
    }

    fun solve(left: Int, right: Int): Int {
        return prefixsum[right] - prefixsum[left - 1]
    }
}
