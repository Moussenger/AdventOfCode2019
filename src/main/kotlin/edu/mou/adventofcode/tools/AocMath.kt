package edu.mou.adventofcode.tools

object AocMath {
    fun permutations(elements: IntRange, current: List<Int> = listOf()): List<List<Int>> {
        return permutations(elements.toList(), current)
    }

    fun <T> permutations(elements: List<T>, current: List<T> = listOf()): List<List<T>> {
        if (elements.isEmpty()) return listOf(current)

        val permutes = mutableListOf<List<T>>()

        for (element in elements) {
            val permute = permutations(elements.toMutableList().apply { remove(element) }, current + listOf(element))
            permutes += permute
        }

        return permutes
    }

    fun <T> combinations(elements: List<T>, size: Int, current: List<T> = listOf()): List<List<T>> {
        if (current.size == size) return listOf(current)

        val combs = mutableListOf<List<T>>()

        for (element in elements) {
            val nextElements = elements.toMutableList().takeLastWhile { it != element }
            combs += combinations(nextElements, size, current + listOf(element))
        }

        return combs
    }

    fun gcd(x: Long, y: Long): Long {
        return if (y == 0L) x else gcd(y, x % y)
    }

    fun lcm(vararg numbers: Long): Long {
        return numbers.reduce { x, y -> x * (y / gcd(x, y)) }
    }
}