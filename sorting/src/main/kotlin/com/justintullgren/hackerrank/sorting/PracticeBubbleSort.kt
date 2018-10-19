package com.justintullgren.hackerrank.sorting

import java.util.*

fun practiceBubbleSort(arr: Array<Int>): Array<Int> {
    val result = arr.copyOf()

    for (pass in 0..arr.lastIndex) {
        for (current in 0 until arr.lastIndex - pass) {
            if (arr[current] > arr[current + 1]) {
                val temp = arr[current]
                arr[current] = arr[current + 1]
                arr[current + 1] = temp
            }
        }
    }

    return result
}

val testData = Pair(
        arrayOf(2, 5, 3, 4, 1),
        arrayOf(1, 2, 3, 4, 5)
)

fun main(args: Array<String>) {
    val answer = practiceBubbleSort(testData.first)
    println("""Input: ${Arrays.toString(testData.first)}
        |Output: ${Arrays.toString(answer)}
        |Expected: ${Arrays.toString(testData.second)}
    """.trimMargin())
}