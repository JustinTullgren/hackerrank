package com.justintullgren.hackerrank.sorting

typealias MaxToys = Int
typealias Money = Int

/**
 * @see <a href="https://www.hackerrank.com/challenges/mark-and-toys/problem">Problem</a>
 */
fun maximumToys(toyPrices: Array<Money>, totalMoneyToSpend: Money): MaxToys =
        toyPrices.sortedArray().fold(Pair(totalMoneyToSpend, 0)) { pair, toyPrice ->
            if (pair.first >= toyPrice) {
                val remainingMoneyToSpend = pair.first - toyPrice
                val totalToysBought = pair.second + 1
                Pair(remainingMoneyToSpend, totalToysBought)
            } else {
                pair
            }

        }.second
