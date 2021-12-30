package edu.mou.adventofcode.day01TyrannyRocketEquation

import edu.mou.adventofcode.tools.DayProblem

class Day01TyrannyRocketEquation : DayProblem<Int, Int>(day = "01", name = "The Tyranny of the Rocket Equation") {
    override fun solvePart1(vararg args: String): Int {
        return input.sumOf { it.toInt() / 3 - 2 }
    }

    override fun solvePart2(vararg args: String): Int {
        return input.sumOf { getRecursiveFuel(it.toInt(), 0) }
    }

    private tailrec fun getRecursiveFuel(amount: Int, total: Int): Int {
        val fuel = amount / 3 - 2
        return if (fuel < 0) total else getRecursiveFuel(fuel, total + fuel)
    }
}

fun main() {
    println("Part 1: ${Day01TyrannyRocketEquation().solvePart1()}")
    println("Part 2: ${Day01TyrannyRocketEquation().solvePart2()}")
}