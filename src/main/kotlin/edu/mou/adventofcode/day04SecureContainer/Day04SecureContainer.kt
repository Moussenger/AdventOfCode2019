package edu.mou.adventofcode.day04SecureContainer

import edu.mou.adventofcode.tools.DayProblem

class Day04SecureContainer : DayProblem<Int, Int>(day = "04", name = "Secure Container") {
    override fun solvePart1(vararg args: String): Int {
        return getSequence()
            .filter { number -> number.all { it[0] <= it[1] } }
            .filter { number -> number.any { it[0] == it[1] } }
            .count()
    }

    override fun solvePart2(vararg args: String): Int {
        return getSequence()
            .filter { number -> number.all { it[0] <= it[1] } }
            .filter { number -> number.filter { it[0] == it[1] }.groupBy { it }.values.map { it.size }.contains(1) }
            .count()
    }

    private fun getSequence(): Sequence<Sequence<List<Char>>> {
        return input
            .first()
            .split("-")
            .map { it.toInt() }.run { get(0)..get(1) }
            .asSequence()
            .map { it.toString().toList().windowed(2).asSequence() }
    }
}

fun main() {
    println("Part 1: ${Day04SecureContainer().solvePart1()}")
    println("Part 2: ${Day04SecureContainer().solvePart2()}")
}