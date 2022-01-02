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
}