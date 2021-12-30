package edu.mou.adventofcode.day03CrossedWires

import edu.mou.adventofcode.tools.DayProblem

class Day03CrossedWires : DayProblem<Int, Int>(day = "03", name = "Crossed Wires") {
    override fun solvePart1(vararg args: String): Int {
        val (wire1, wire2) = parseWirePaths()

        return wire1.intersections(wire2).minOf { it.manhattan() }
    }

    override fun solvePart2(vararg args: String): Int {
        val (wire1, wire2) = parseWirePaths()

        return wire1.intersections(wire2).minOf { wire1.steps(it) + wire2.steps(it) }
    }

    private fun parseWirePaths(): List<WirePath> {
        return input
            .asSequence()
            .map { it.split(",").map { movement -> Movement.parse(movement) } }
            .map { WirePath(mutableListOf(Position(0, 0))).apply { add(it) } }
            .toList()
    }
}

fun main() {
    println("Part 1: ${Day03CrossedWires().solvePart1()}")
    println("Part 2: ${Day03CrossedWires().solvePart2()}")
}