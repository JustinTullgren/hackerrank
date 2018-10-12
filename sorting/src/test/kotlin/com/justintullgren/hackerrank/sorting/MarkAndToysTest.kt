package com.justintullgren.hackerrank.sorting

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class MarkAndToysTest {

    @Test
    fun `Test find max toys for mark`() {
        TEST_DATA.forEach {
            assertThat(maximumToys(it.toyPrices, it.maxMoney))
                    .`as`("""Toy Prices: ${it.toyPrices}
                        |Max Money: ${it.maxMoney}
                        |Answer: ${it.answer}
                    """.trimMargin())
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private val TEST_DATA = listOf(
                TestData(
                        arrayOf(1, 12, 5, 111, 200, 1000, 10),
                        50,
                        4
                ),
                TestData(
                        arrayOf(1, 2, 3, 4),
                        7,
                        3
                ),
                TestData(
                        arrayOf(3, 7, 2, 9, 4),
                        15,
                        3
                )
        )
    }

    private data class TestData(val toyPrices: Array<Int>, val maxMoney: Int, val answer: Int)
}