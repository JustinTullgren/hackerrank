package com.justintullgren.hackerrank.hashmaps

/**
 * @param s1 first string
 * @param s2 second string
 * @return either YES or NO based on whether the strings share a common substring.
 * @see <a href="https://www.hackerrank.com/challenges/two-strings/problem">Two Strings</a>
 */
fun twoStrings(s1: String, s2: String): String {

    /*
     working solution but big data takes time.
    val containsAtLeastOneSameLetter = s1.toCharArray()
            .fold(false) { result: Boolean, letter: Char ->
                result || letter in s2
            }

     */
    var containsAtLeastOneSameLetter = false
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (letter in alphabet) {
        if (s1.indexOf(letter) > -1 && s2.indexOf(letter) > -1) {
            containsAtLeastOneSameLetter = true
            break
        }
    }
    return if (containsAtLeastOneSameLetter) "YES" else "NO"

}