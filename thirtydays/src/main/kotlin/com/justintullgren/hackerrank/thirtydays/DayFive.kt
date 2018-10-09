package com.justintullgren.hackerrank.thirtydays

import java.util.*


/**
 * @see <a href="https://www.hackerrank.com/challenges/30-loops/problem">Problem</a>
 */
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    for (i in 1..10) {
        println("$n x $i = ${i * n}")
    }
}