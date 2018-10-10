package com.justintullgren.hackerrank.strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class MakingAnagramsTest {

    @Test
    fun `Test count deletions to make anagrams`() {
        TEST_DATA.forEach {
            assertThat(makeAnagram(it.a, it.b))
                    .`as`("StringA: ${it.a}\nStringB: ${it.b}\nAnswer: ${it.answer}")
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                TestData(
                        "cde",
                        "abc",
                        4
                ),
                TestData(
                        "fcrxzwscanmligyxyvym",
                        "jxwtrhvujlmrpdoqbisbwhmgpmeoke",
                        30
                ),
                TestData(
                        "showman",
                        "woman",
                        2
                )
        )
    }

    private data class TestData(val a: String, val b: String, val answer: Int)
}