package com.justintullgren.hackerrank.arrays

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class LeftRotationTest {

    @Test
    fun `Test Left Rotation`() {
        TEST_DATA.forEach {
            assertThat(leftRotation(it.input, it.numberOfLeftRotations))
                    .`as`("Input: ${it.input}\nRotations: ${it.numberOfLeftRotations}\nAnswer: ${it.answer}")
                    .isEqualTo(it.answer)
        }
    }

    companion object {
        private val TEST_DATA = arrayOf(
                TestData(
                        arrayOf(1, 2, 3, 4, 5),
                        4,
                        arrayOf(5, 1, 2, 3, 4)
                ),
                TestData(
                        arrayOf(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51),
                        10,
                        arrayOf(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77)
                ),
                TestData(
                        arrayOf(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97),
                        13,
                        arrayOf(87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60)
                ),
                TestData(
                        arrayOf(1, 2, 3),
                        3,
                        arrayOf(1, 2, 3)
                )
        )
    }

    /*
        this should not happen because its constrained to number of rotations being the same as the size of the input
        5 rotations
        1,2,3
        2,3,1
        3,1,2
        1,2,3
        2,3,1



     */

    private data class TestData(val input: Array<Int>, val numberOfLeftRotations: Int, val answer: Array<Int>)

}
