package com.justintullgren.hackerrank.dynamicprogramming

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

class MaxArraySumTest {

    @Test
    fun `Test Max subset sum`() {
        TEST_DATA.forEach {
            assertThat(maxSubsetSum(it.first))
                    .`as`("""Input: ${Arrays.toString(it.first)}
                        |Answer: ${it.second}
                    """.trimMargin())
                    .isEqualTo(it.second)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                Pair(
                        arrayOf(3, 7, 4, 6, 5),
                        13
                ),
                Pair(
                        arrayOf(2, 1, 5, 8, 4),
                        11
                ),
                Pair(
                        arrayOf(3, 5, -7, 8, 10),
                        15
                )
        )
    }

}