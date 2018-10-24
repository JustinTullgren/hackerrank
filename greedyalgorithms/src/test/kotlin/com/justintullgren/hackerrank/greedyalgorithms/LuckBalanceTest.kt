package com.justintullgren.hackerrank.greedyalgorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*


class LuckBalanceTest {
    @Test
    fun `test luckBalance`() {
        TEST_DATA.forEach {
            assertThat(luckBalance(it.lossesAllowed, it.contests))
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                TestData(29,
                        3,
                        arrayOf(
                                arrayOf(5, 1),
                                arrayOf(2, 1),
                                arrayOf(1, 1),
                                arrayOf(8, 1),
                                arrayOf(10, 0),
                                arrayOf(5, 0)
                        ))
        )
    }

    private data class TestData(val answer: Int, val lossesAllowed: Int, val contests: Array<Array<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (answer != other.answer) return false
            if (lossesAllowed != other.lossesAllowed) return false
            if (!Arrays.deepEquals(contests, other.contests)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = answer
            result = 31 * result + lossesAllowed
            result = 31 * result + Arrays.deepHashCode(contests)
            return result
        }
    }
}