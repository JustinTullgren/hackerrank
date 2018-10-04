package com.justintullgren.hackerrank.hashmaps

/**
 * @see <a href="https://www.hackerrank.com/challenges/ctci-ransom-note/problem">Ransome Note Problem</a>
 */
fun checkMagazine(
        magazine: Array<String>,
        note: Array<String>): Unit {

    if (checkNoteCanBeMadeFromMagazine(magazine, note)) {
        println("Yes")
    } else {
        println("No")
    }

}

fun checkNoteCanBeMadeFromMagazine(
        magazine: Array<String>,
        note: Array<String>): Boolean {

    val noteMap = mutableMapOf<String, Int>()
    for (word in note) {
        noteMap[word] = noteMap[word]?.plus(1) ?: 1
    }
    for (word in magazine) {
        noteMap.computeIfPresent(word) { word: String, count: Int ->
            count - 1
        }
    }

    return noteMap.all { it.value <= 0 }
}