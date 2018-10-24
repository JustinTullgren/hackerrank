package com.justintullgren.hackerrank.greedyalgorithms

/**
 * @see <a href="https://www.hackerrank.com/challenges/luck-balance/problem">problem</a>
 */
fun luckBalanceFast(k: Int, contests: Array<Array<Int>>): Int {
    val importantLuck = mutableListOf<Int>()
    var totalLuck = 0
    for (index in contests.indices) {
        val luck = contests[index][0]
        totalLuck += luck
        if (contests[index][1] == 1) {
            importantLuck.add(luck)
        }
    }
    importantLuck.sort()
    val allowedLosses = importantLuck.size - k
    var lossesSum = 0
    for (index in 0 until allowedLosses) {
        lossesSum += importantLuck[index]
    }
    return totalLuck - 2 * lossesSum
}

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    val (totalLuck, importantContests) = contests.fold(Pair(0, arrayOf<Array<Int>>())) { result, contest ->
        val important = contest[1] == 1
        val totalLuck = result.first + contest[0]
        val importantContests = if (important) {
            result.second + contest
        } else {
            result.second
        }
        Pair(totalLuck, importantContests)
    }

    importantContests.sortBy { it[0] }
    return totalLuck - 2 * importantContests.take(importantContests.size - k).sumBy { it[0] }
}
