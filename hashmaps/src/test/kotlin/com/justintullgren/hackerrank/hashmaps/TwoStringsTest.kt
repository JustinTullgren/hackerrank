package com.justintullgren.hackerrank.hashmaps

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TwoStringsTest {

    @Test
    fun `Test two strings share common substring`() {

        TEST_DATA.forEach {
            assertThat(twoStrings(it.string1, it.string2))
                    .`as`("First: %s \nSecond: %s", it.string1, it.string2)
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private const val YES = "YES"
        private const val NO = "NO"
        private val TEST_DATA = listOf(
                TestData(
                        YES,
                        "hello",
                        "world"
                ),
                TestData(
                        NO,
                        "hi",
                        "world"
                ),
                TestData(
                        NO,
                        "wouldyoulikefries",
                        "abcabcabcabcabcabc"
                ),
                TestData(
                        YES,
                        "hackerrankcommunity",
                        "cdecdecdecde"
                ),
                TestData(
                        YES,
                        "jackandjill",
                        "wentupthehill"
                ),
                TestData(
                        NO,
                        "writetoyourparents",
                        "fghmqzldbc"
                ),
                TestData(
                        YES,
                        "aardvark",
                        "apple"
                ),
                TestData(
                        NO,
                        "beetroot",
                        "sandals"
                )
        )
    }

    private data class TestData(
            val answer: String,
            val string1: String,
            val string2: String
    )
}