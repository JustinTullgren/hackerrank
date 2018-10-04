package com.justintullgren.hackerrank.thirtydays

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DayTwoTest {

    @Test
    fun `Calculate Total Meal Cost`() {
        TEST_DATA.forEach {
            assertThat(
                    totalMealCost(
                            it.mealCost,
                            it.tip,
                            it.tax))
                    .`as`("Meal: ${it.mealCost},\nTip: ${it.tip},\nTax: ${it.tax}")
                    .isEqualTo(it.answer)
        }
    }


    companion object {
        private val TEST_DATA = listOf(
                TestData(
                        15,
                        12.00,
                        20,
                        8),
                TestData(
                        19,
                        15.50,
                        15,
                        10
                )
        )
    }

    private data class TestData(
            val answer: Long,
            val mealCost: Double,
            val tip: Int,
            val tax: Int)
}