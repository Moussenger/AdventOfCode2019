package edu.mou.adventofcode.day11SpacePolice

import edu.mou.adventofcode.tools.DayProblem
import edu.mou.adventofcode.tools.intcode.IntCodeInterpreter
import edu.mou.adventofcode.tools.models.Point

class Day11SpacePolice : DayProblem<Int, String>(day = "11", name = "Space Police") {
    private val directions = listOf(Point.up(), Point.right(), Point.down(), Point.left())

    override fun solvePart1(vararg args: String): Int {
        return paintSpacecraft(initialColor = 0).keys.size
    }

    override fun solvePart2(vararg args: String): String {
        val panels = paintSpacecraft(initialColor = 1)
        val width = (panels.keys.map { it.x }.minOf { it })..(panels.keys.map { it.x }.maxOf { it })
        val height = (panels.keys.map { it.y }.minOf { it })..(panels.keys.map { it.y }.maxOf { it })
        val spaceCraftPainted = mutableListOf<String>()

        for (y in height) {
            val newRow = mutableListOf<String>()
            for (x in width) {
                newRow.add(panels.getOrDefault(Point(x, y), 0).let { if (it == 0L) " " else "#" })
            }
            spaceCraftPainted.add(newRow.joinToString(""))
        }

        return "\n" + spaceCraftPainted.joinToString("\n")
    }

    private fun paintSpacecraft(initialColor: Long): Map<Point, Long> {
        val panels = mutableMapOf<Point, Long>()
        var directionIndex = 0
        var point = Point(0, 0)
        val intCodeInput = mutableListOf<Long>(initialColor)
        val intCode = IntCodeInterpreter(input.first(), intCodeInput, pauseOnEmptyInput = true)

        while (!intCode.isHalted()) {
            val (color, mode) = intCode.apply { run() }.output().takeLast(2)
            val (newPoint, newDirection) = rotate(point, directionIndex, mode)
            intCode.input(listOf(panels.getOrDefault(newPoint, 0)))
            panels[point] = color
            point = newPoint
            directionIndex = newDirection
        }

        return panels
    }

    private fun rotate(point: Point, directionIndex: Int, mode: Long): Pair<Point, Int> {
        val newDirection = when (mode) {
            0L -> Math.floorMod(directionIndex - 1, directions.size)
            else -> Math.floorMod(directionIndex + 1, directions.size)
        }

        return Pair(point + directions[newDirection], newDirection)
    }
}

fun main() {
    println("Part 1: ${Day11SpacePolice().solvePart1()}")
    println("Part 2: \n${Day11SpacePolice().solvePart2()}")
}