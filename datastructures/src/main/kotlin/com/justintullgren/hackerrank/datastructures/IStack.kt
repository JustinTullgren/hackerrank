package com.justintullgren.hackerrank.datastructures

interface IStack<T> {
    val depth: Int
    fun push(item: T)
    fun pop(): T
    fun peek(): T
}