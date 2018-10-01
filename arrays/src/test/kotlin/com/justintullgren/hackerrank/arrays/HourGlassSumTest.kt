package com.justintullgren.hackerrank.arrays

import hourglassSum
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HourGlassSumTest {
    companion object {
        private const val ANSWER_ONE = 19
        private const val ANSWER_TWO = 13
        private const val ANSWER_THREE = 28
    }

    @Test
    fun `Hour Glass Sum Test`() {
        var result = hourglassSum(testCase1())
        assertThat(result).isEqualTo(ANSWER_ONE)

        result = hourglassSum(testCase2())
        assertThat(result).isEqualTo(ANSWER_TWO)

        result = hourglassSum(testCase3())
        assertThat(result).isEqualTo(ANSWER_THREE)
    }

    private fun testCase3(): Array<Array<Int>> = arrayOf(
            arrayOf(-9, -9, -9, 1, 1, 1),
            arrayOf(0, -9, 0, 4, 3, 2),
            arrayOf(-9, -9, -9, 1, 2, 3),
            arrayOf(0, 0, 8, 6, 6, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
    )


    private fun testCase2(): Array<Array<Int>> = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 9, 2, -4, -4, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, -1, -2, -4, 0)
    )

    private fun testCase1(): Array<Array<Int>> = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 0, 2, 4, 4, 0),
            arrayOf(0, 0, 0, 2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
    )


    /* test case 0

        input:
            1 1 1 0 0 0
            0 1 0 0 0 0
            1 1 1 0 0 0
            0 0 2 4 4 0
            0 0 0 2 0 0
            0 0 1 2 4 0

        output: 19
     */

    /* test case 1

        input:
            1 1 1 0 0 0
            0 1 0 0 0 0
            1 1 1 0 0 0
            0 9 2 -4 -4 0
            0 0 0 -2 0 0
            0 0 -1 -2 -4 0

        output: 13
     */

    /* test case 2

        input:
            -9 -9 -9 1 1 1
            0 -9 0 4 3 2
            -9 -9 -9 1 2 3
            0 0 8 6 6 0
            0 0 0 -2 0 0
            0 0 1 2 4 0

        output: 28
     */
}