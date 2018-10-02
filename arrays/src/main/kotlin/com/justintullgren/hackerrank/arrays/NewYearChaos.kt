package com.justintullgren.hackerrank.arrays

import kotlin.math.max

/**
 * <p> Example:
 * <ul>
 *     <li>2 1 5 3 4 = 3</li>
 *     <li>2 5 1 3 4 = Too chaotic</li>
 * </ul>
 * </p>
 * @see <a href="https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">
 *     Test page</a>
 */
fun minimumBribes(q: Array<Int>): Unit {

    println(getMinimumBribes(q.toList()))

}

fun getMinimumBribes(queue: List<Int>): Any {
    var tooChaotic = false
    var minBribes = 0

    val reversedQueue = queue.reversed()
    // walk towards front of line
    for (positionInLine in reversedQueue.indices) {
        // where we started
        val originalPosition = queue[positionInLine]
        val previousPositionInLine = (positionInLine + 1)
        // if you went forwards in the line check how many jumps you made
        // if the previous position (index) is less than original by two
        // too many bribes
        if (originalPosition - previousPositionInLine > MAX_BRIBES) {
            tooChaotic = true
            break
        } else {
            val maxForwardPosition = originalPosition - MAX_BRIBES
            for (possiblePosition in (max(0, maxForwardPosition)..positionInLine)) {
                val originalAtPossiblePosition = queue[possiblePosition]
                // if a person in front
                // has a larger starting position
                // a bribe happened
                if (originalAtPossiblePosition > originalPosition) {
                    minBribes += 1
                }

            }
        }
    }


    return if (tooChaotic) "Too chaotic" else minBribes
}

private const val MAX_BRIBES = 2
