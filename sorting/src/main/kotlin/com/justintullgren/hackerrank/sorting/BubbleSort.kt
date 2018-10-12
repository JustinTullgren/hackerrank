package com.justintullgren.hackerrank.sorting

fun countSwaps(a: Array<Int>): Unit {

    val answer = bubbleSort(a)

    println("Array is sorted in ${answer.first} swaps.")
    println("First Element: ${answer.second.first()}")
    println("Last Element: ${answer.second.last()}")

}

fun bubbleSort(array: Array<Int>): Pair<Int, Array<Int>> {
    var swaps = 0
    var isSorted = false
    var last = array.lastIndex - 1

    while (!isSorted) {
        isSorted = true
        for (i in 0..last) {
            val next = i + 1
            if (array[i] > array[next]) {
                val temp = array[i]
                array[i] = array[next]
                array[next] = temp
                isSorted = false
                swaps++
            }
        }
        last--
    }
    return Pair(swaps, array)
}

