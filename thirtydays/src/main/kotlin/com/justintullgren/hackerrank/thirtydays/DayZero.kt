package com.justintullgren.hackerrank.thirtydays

import java.util.*

/**
 * This does not read from console so just putting here for challenge
 * @see <a href="https://www.hackerrank.com/challenges/30-hello-world/problem">Problem</a>
 */
fun dayZero() {
    val scanner = Scanner(System.`in`)
    if (!scanner.hasNextLine()) throw IllegalStateException("Expected to have another line.")
    val nextLine = scanner.nextLine()
    println("Hello, World. \n$nextLine")
    scanner.close()
}