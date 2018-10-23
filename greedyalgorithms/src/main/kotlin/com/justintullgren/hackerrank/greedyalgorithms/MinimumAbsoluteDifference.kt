package com.justintullgren.hackerrank.greedyalgorithms

/**
 * @see <a href="https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem">problem</a>
 */
fun minimumAbsoluteDifference(arr: Array<Int>): Int =
        arr.foldIndexed(Int.MAX_VALUE) { index, minimumDiff, intA ->
            var returnResult = minimumDiff
            ((index + 1)..arr.lastIndex).forEach { int ->
                val intB = arr[int]
                val absoluteDiff = Math.abs(intA - intB)
                if (absoluteDiff < returnResult) {
                    returnResult = absoluteDiff
                }
            }
            returnResult
        }

fun minimumAbsoluteDifferenceFast(arr: Array<Int>): Int {
    val sorted = arr.sortedArray()
    var min = Math.abs(sorted[0] - sorted[1])
    for (index in 2..sorted.lastIndex) {
        val diff = Math.abs(sorted[index] - sorted[index - 1])
        if (diff < min) {
            min = diff
        }
    }
    return min
}