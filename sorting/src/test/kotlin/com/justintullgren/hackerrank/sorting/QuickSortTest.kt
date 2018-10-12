package com.justintullgren.hackerrank.sorting

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class QuickSortTest {

    @Test
    fun `Test quicksort`() {
        TEST_DATA.forEach {
            assertThat(quickSort(it.first))
                    .`as`("""Input:${it.first}
                        |Answer: ${it.second}
                    """.trimMargin())
                    .isEqualTo(it.second)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                Pair(
                        arrayOf(3, 8, 10, 2, 7, 4, 5, 6, 1, 9),
                        arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                ),
                Pair(
                        arrayOf(22, 30, 23, 40, 11, 21),
                        arrayOf(11, 21, 22, 23, 30, 40)
                )
        )
    }
}