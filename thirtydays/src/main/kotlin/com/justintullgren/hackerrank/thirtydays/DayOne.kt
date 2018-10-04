package com.justintullgren.hackerrank.thirtydays

import java.util.*

/**
 * No inputs or outputs to function, just standard in and standard out. Here for remembering.
 * @see <a href="https://www.hackerrank.com/challenges/30-data-types/problem">Problem</a>
 */
fun dayOne() {
    // Provided
    val i = 4
    val d = 4.0
    val s = "HackerRank "

    // Solution:
    val scan = Scanner(System.`in`)
    val j = scan.nextInt() + i
    scan.nextLine()
    val e = scan.nextDouble() + d
    scan.nextLine()
    val t = s + scan.nextLine()

    // Answer:
    println("$j" + String.format("%.1f", e) + "\n$t")

    scan.close()
}