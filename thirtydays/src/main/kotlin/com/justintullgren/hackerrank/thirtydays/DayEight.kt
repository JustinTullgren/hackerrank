package com.justintullgren.hackerrank.thirtydays

import java.util.*

/**
 * @see <a href="https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem">Problem</a>
 */
fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    val scan = Scanner(System.`in`)

    val numberOfContacts = scan.nextLine().toInt()

    val contacts = mutableMapOf<String, Int>()

    for (i in 0 until numberOfContacts) {
        val input = scan.nextLine().trim().split(" ")
        val name = input[0]
        val number = input[1].toInt()
        contacts[name] = number
    }

    while (scan.hasNextLine()) {
        val name = scan.nextLine().trim()
        val number = contacts.getOrDefault(name, -1)
        if (number > -1) {
            println("$name=$number")
        } else {
            println("Not found")
        }
    }



    scan.close()
}