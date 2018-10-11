package com.justintullgren.hackerrank.thirtydays

import java.util.*

/**
 * @see <a href="https://www.hackerrank.com/challenges/30-recursion/problem">Problem</a>
 */
fun factorial(n: Int): Int = if (n > 1) n * factorial(n - 1) else 1

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val result = factorial(n)

    println(result)
}