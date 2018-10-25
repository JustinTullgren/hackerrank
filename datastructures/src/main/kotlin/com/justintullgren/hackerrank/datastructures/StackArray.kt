package com.justintullgren.hackerrank.datastructures

@Suppress("UNCHECKED_CAST")
class StackArray<T> : IStack<T>, Iterable<T> {

    override fun iterator(): Iterator<T> = object : Iterator<T> {
        private var index = depth
        override fun hasNext(): Boolean = index - 1 >= 0

        override fun next(): T {
            index--
            return stack[index] as T
        }
    }

    private var stack = arrayOfNulls<Any?>(4)

    override var depth: Int = 0
        private set

    override fun push(item: T) {
        when (depth) {
            stack.size -> {
                stack = stack.copyOf(stack.size * 2)
                stack[depth] = item
            }
            else -> stack[depth] = item
        }

        depth++
    }

    override fun pop(): T {
        depth--
        return stack[depth] as T
    }

    override fun peek(): T {
        return stack[depth - 1] as T
    }

}