package com.justintullgren.hackerrank.greedyalgorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class MinimumAbsoluteDifferenceTest {

    @Test
    fun `test minimum absolute difference`() {
        assertThat(minimumAbsoluteDifference(arrayOf(3, -7, 0)))
                .`as`("""Input: 3, -7, 0
                    |Expected: 3
                """.trimMargin())
                .isEqualTo(3)
    }

    @Test
    fun `test minimum absolute difference fast`() {
        assertThat(minimumAbsoluteDifferenceFast(arrayOf(3, -7, 0)))
                .`as`("""Input: 3, -7, 0
                    |Expected: 3
                """.trimMargin())
                .isEqualTo(3)
    }


}