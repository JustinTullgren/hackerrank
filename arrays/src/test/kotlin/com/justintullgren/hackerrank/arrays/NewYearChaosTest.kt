package com.justintullgren.hackerrank.arrays

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class NewYearChaosTest {
    companion object {
        private val TEST_DATA = listOf(
                TestData.NotChaotic(3, listOf(2, 1, 5, 3, 4)),
                TestData.Chaotic(listOf(2, 5, 1, 3, 4)),
                TestData.Chaotic(listOf(5, 1, 2, 3, 7, 8, 6, 4)),
                TestData.NotChaotic(7, listOf(1, 2, 5, 3, 7, 8, 6, 4)),
                TestData.NotChaotic(4, listOf(1, 2, 5, 3, 4, 7, 8, 6))

        )
    }

    @Test
    fun `New Year Chaos Test`() {
        TEST_DATA.forEach {
            when (it) {
                is TestData.NotChaotic -> {
                    val result = getMinimumBribes(it.queue)
                    assertThat(result).isEqualTo(it.answer)
                }
                is TestData.Chaotic -> {
                    val result = getMinimumBribes(it.queue)
                    assertThat(result).isEqualTo(it.answer)
                }
            }
        }

    }


    private sealed class TestData {
        data class Chaotic(val queue: List<Int>) : TestData() {
            val answer = "Too chaotic"
        }

        data class NotChaotic(val answer: Int, val queue: List<Int>) : TestData()
    }

}