package com.justintullgren.hackerrank.strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class AlternatingCharactersTest {

    @Test
    fun `Test minimum deletion for alternating characters`() {
        TEST_DATA.forEach {
            assertThat(alternatingCharacters(it.input))
                    .`as`("\nInput: ${it.input}\nAnswer: ${it.answer}")
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                TestData(
                        "AAAA",
                        3
                ),
                TestData(
                        "BBBBB",
                        4
                ),
                TestData(
                        "ABABABAB",
                        0
                ),
                TestData(
                        "BABABA",
                        0
                ),
                TestData(
                        "AAABBB",
                        4
                ),
                TestData(
                        "AAABBBAABB",
                        6
                ),
                TestData(
                        "AABBAABB",
                        4
                ),
                TestData(
                        "ABABABAA",
                        1
                ),
                TestData(
                        "ABBABBAA",
                        3
                )
        )
    }

    private data class TestData(val input: String, val answer: Int)
}
