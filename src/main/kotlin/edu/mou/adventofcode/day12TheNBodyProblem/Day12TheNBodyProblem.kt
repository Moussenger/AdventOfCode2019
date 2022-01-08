package edu.mou.adventofcode.day12TheNBodyProblem

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.models.Point


class Day12TheNBodyProblem : DayProblem<Int, Long>(day = "12", name = "The N Body Problem") {
    override fun solvePart1(vararg args: String): Int {
        return MoonSystem(parseMoons()).apply { repeat(args.first().toInt()) { applyGravity() } }.energy()
    }

    override fun solvePart2(vararg args: String): Long {
        return MoonSystem(parseMoons()).cycleLength()
    }

    private fun parseMoons(): List<Moon> {
        return input
            .map { it.replace(">", "").split(",").map { coord -> coord.split("=").last().toInt() } }
            .map { Moon(Point(it[0], it[1], it[2])) }
    }
}

fun main() {
    println("Part 1: ${Day12TheNBodyProblem().solvePart1("1000")}")
    println("Part 2: ${Day12TheNBodyProblem().solvePart2()}")
}