package com.justintullgren.hackerrank.thirtydays

import java.util.*


/**
 * @see <a href="https://www.hackerrank.com/challenges/30-conditional-statements/problem">Problem</a>
 */
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val N = scan.nextLine().trim().toInt()
    // ODD
    if (N % 2 != 0) {
        println("Weird")
    } else if (N in 2..5) {
        println("Not Weird")
    } else if (N in 6..20) {
        println("Weird")
    } else {
        println("Not Weird")
    }
}