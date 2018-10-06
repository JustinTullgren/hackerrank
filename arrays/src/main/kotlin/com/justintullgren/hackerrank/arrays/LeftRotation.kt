package com.justintullgren.hackerrank.arrays

/**
 * @see <a href="https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem">Problem</a>
 */
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val result = leftRotation(a, d)

    println(result.joinToString(separator = " "))

    return result
}

fun leftRotation(originalArray: Array<Int>, numberOfLeftRotations: Int): Array<Int> {
    /*
    [1, 2, 3, 4, 5]
    3 rotations
    [2, 3, 4, 5, 1]
    [3, 4, 5, 1, 2]
    [4, 5, 1, 2, 3]

    */
    if (numberOfLeftRotations >= originalArray.size) {
        return originalArray
    }

    val slicedTo = originalArray.sliceArray(0 until numberOfLeftRotations)
    val slicedFrom = originalArray.sliceArray(numberOfLeftRotations..originalArray.lastIndex)

    return slicedFrom + slicedTo
}