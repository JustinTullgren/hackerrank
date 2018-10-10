package com.justintullgren.hackerrank.strings

import kotlin.math.absoluteValue

/**
 * @return [Int] Representing the minimum total characters that must be deleted to make the strings anagrams.
 * @see <a href="https://www.hackerrank.com/challenges/ctci-making-anagrams/problem">Problem</a>
 */
fun makeAnagram(a: String, b: String): Int {
    val characterCounts = IntArray(26)
    for (letter in a) {
        characterCounts[letter - 'a']++
    }
    for (letter in b) {
        characterCounts[letter - 'a']--
    }
    return characterCounts.fold(0) { numberDeletions, count -> numberDeletions + count.absoluteValue }
}