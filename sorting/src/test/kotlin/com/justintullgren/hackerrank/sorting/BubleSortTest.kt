package com.justintullgren.hackerrank.sorting

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class BubleSortTest {

    @Test
    fun `Test Bubble Sort`() {
        TEST_DATA.forEach {
            assertThat(bubbleSort(it.unsorted))
                    .`as`("Unsorted:${it.unsorted}\nSorted: ${it.sorted}\nNumberOfExpectedSwaps: ${it.numberOfSwaps}")
                    .isEqualToComparingFieldByField(Pair(it.numberOfSwaps, it.sorted))
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                TestData(
                        arrayOf(2, 7, 4, 5),
                        arrayOf(2, 4, 5, 7),
                        2
                ),
                TestData(
                        arrayOf(5, 4, 3, 2, 1),
                        arrayOf(1, 2, 3, 4, 5),
                        10
                )
        )
    }

    private data class TestData(val unsorted: Array<Int>, val sorted: Array<Int>, val numberOfSwaps: Int)

    /*
    5,4,3,2,1   0
    4,5,3,2,1   1
    4,3,5,2,1   2
    4,3,2,5,1   3
    4,3,2,1,5   4
    3,4,2,1,5   5
    3,2,4,1,5   6
    3,2,1,4,5   7
    2,3,1,4,5   8
    2,1,3,4,5   9
    1,2,3,4,5   10
     */
}