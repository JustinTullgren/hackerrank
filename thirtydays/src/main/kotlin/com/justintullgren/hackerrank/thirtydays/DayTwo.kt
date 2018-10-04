package com.justintullgren.hackerrank.thirtydays

/**
 * @see <a href="https://www.hackerrank.com/challenges/30-operators/problem">Problem</a>
 */
fun totalMealCost(mealCost: Double, tipPercent: Int, taxPercent: Int): Long =
        Math.round(
                mealCost +
                        mealCost.times(taxPercent.div(100.00)) +
                        mealCost.times(tipPercent.div(100.00))
        )

