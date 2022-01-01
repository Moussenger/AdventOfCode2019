package edu.mou.adventofcode.day05SunnyChanceAsteroids

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter

class Day05SunnyChanceAsteroids : DayProblem<Int, Int>(day = "05", name = "Sunny with a Chance of Asteroids") {
    override fun solvePart1(vararg args: String): Int {
        return runInterpreter(*args)
    }

    override fun solvePart2(vararg args: String): Int {
        return runInterpreter(*args)
    }

    private fun runInterpreter(vararg args: String): Int {
        val interpreter = IntCodeInterpreter(input.first(), args.map { it.toInt() }.toMutableList())
        interpreter.run()
        return interpreter.output().last()
    }
}

fun main() {
    println("Part 1: ${Day05SunnyChanceAsteroids().solvePart1("1")}")
    println("Part 2: ${Day05SunnyChanceAsteroids().solvePart2("5")}")
}