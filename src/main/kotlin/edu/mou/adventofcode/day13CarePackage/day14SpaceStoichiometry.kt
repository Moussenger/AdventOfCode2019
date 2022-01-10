package edu.mou.adventofcode.day13CarePackage

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter
import kotlin.math.absoluteValue

val values = mapOf(
    0L to " ",
    1L to "#",
    2L to "=",
    3L to "_",
    4L to "o",
)

class Day13CarePackage : DayProblem<Int, Int>(day = "13", name = "Care Package") {
    override fun solvePart1(vararg args: String): Int {
        return IntCodeInterpreter(getCode())
            .apply { run() }
            .output()
            .chunked(3)
            .map { it.last() }
            .filter { it == 2L }.size
    }

    override fun solvePart2(vararg args: String): Int {
        val machine = IntCodeInterpreter(getCode(2), pauseOnEmptyInput = true)

        while (!machine.isHalted()) {
            val scene = machine.apply { run() }.output().chunked(3)
            val ballPosition = scene.last { it[2] == 4L }[0]
            val paddlePosition = scene.last { it[2] == 3L }[0]
            val diff = ballPosition - paddlePosition
            val move = if (diff != 0L) diff / diff.absoluteValue else 0L
            machine.input(listOf(move))
        }

        return machine.output().chunked(3).last { it[0] == -1L }[2].toInt()
    }

    private fun getCode(quarters: Long = 1): MutableList<Long> {
        return input.first().split(",").map { it.toLong() }.toMutableList().apply { removeFirst(); add(0, quarters) }
    }
}

fun main() {
    println("Part 1: ${Day13CarePackage().solvePart1()}")
    println("Part 2: ${Day13CarePackage().solvePart2()}")
}