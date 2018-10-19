package com.justintullgren.hackerrank.sorting

fun quickSort(array: Array<Int>): Array<Int> {
    quickSort(array, 0, array.lastIndex)
    return array
}

private fun quickSort(array: Array<Int>, leftIndex: Int, rightIndex: Int) {
    if (leftIndex >= rightIndex) {
        return
    }

    val pivotComparisonValue = array[(leftIndex + rightIndex) / 2]
    val splitIndex = splitSort(array, leftIndex, rightIndex, pivotComparisonValue)
    quickSort(array, leftIndex, splitIndex - 1)
    quickSort(array, splitIndex, rightIndex)
}

fun splitSort(array: Array<Int>, startingLeftIndex: Int, startingRightIndex: Int, pivotComparisonValue: Int): Int {
    var leftIndex = startingLeftIndex
    var rightIndex = startingRightIndex
    while (leftIndex <= rightIndex) {
        while (array[leftIndex] < pivotComparisonValue) {
            // walk left pointer to the right until we have a value that is greater than pivot value
            // IE out of order
            leftIndex++
        }

        while (array[rightIndex] > pivotComparisonValue) {
            // walk right pointer to the left until we have a value that is less than pivot value
            // IE out of order
            rightIndex--
        }

        // if it makes sense to swap the values, swap
        if (leftIndex <= rightIndex) {
            val temp = array[leftIndex]
            array[leftIndex] = array[rightIndex]
            array[rightIndex] = temp

            // we've swapped at this point,
            // so don't process these indexes again
            rightIndex--
            leftIndex++
        }
    }
    return leftIndex

}

