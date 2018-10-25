package com.justintullgren.hackerrank.datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class StackArrayTest {

    private lateinit var subject: StackArray<Int>

    @Before
    fun before() {
        subject = StackArray()
    }

    @Test
    fun `test push adds item`() {
        subject.push(1)
        assertThat(subject.depth).isEqualTo(1)
        subject.push(1)
        assertThat(subject.depth).isEqualTo(2)
    }

    @Test
    fun `test peek returns first item`() {
        subject.push(42)
        assertThat(subject.peek()).isEqualTo(42)
        subject.push(101)
        assertThat(subject.peek()).isEqualTo(101)
        subject.push(44)
        assertThat(subject.peek()).isEqualTo(44)
        subject.push(102)
        assertThat(subject.peek()).isEqualTo(102)
        subject.push(46)
        assertThat(subject.peek()).isEqualTo(46)
        subject.push(103)
        assertThat(subject.peek()).isEqualTo(103)
    }

    @Test
    fun `test pop returns first item and clears reference`() {
        subject.push(42)
        subject.push(44)
        assertThat(subject.depth).isEqualTo(2)

        var popped = subject.pop()

        assertThat(popped).isEqualTo(44)
        assertThat(subject.depth).isEqualTo(1)

        popped = subject.pop()

        assertThat(popped).isEqualTo(42)
        assertThat(subject.depth).isEqualTo(0)

    }

    @Test
    fun `test iteration is last in first out`() {
        subject.push(42)
        subject.push(44)
        val iterator = subject.iterator()
        val items = mutableListOf<Int>()
        while (iterator.hasNext()) {
            items.add(iterator.next())
        }
        assertThat(items.size).isEqualTo(2)
        assertThat(items[0]).isEqualTo(44)
        assertThat(items[1]).isEqualTo(42)

        items.clear()

        for (item in subject) {
            items.add(item)
        }

        assertThat(items.size).isEqualTo(2)
        assertThat(items[0]).isEqualTo(44)
        assertThat(items[1]).isEqualTo(42)
    }
}
