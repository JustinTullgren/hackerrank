package com.justintullgren.hackerrank.strings

/**
 * @see <a href="https://www.hackerrank.com/challenges/alternating-characters/problem">Problem</a>
 */
fun alternatingCharacters(s: String): Int {
    return s.foldIndexed(0) { index: Int, numberDeletions: Int, letter: Char ->
        when {
            index == 0 -> 0
            letter != s[index - 1] -> numberDeletions
            else -> {
                numberDeletions + 1
            }
        }

    }
}