package edu.mou.adventofcode.day03CrossedWires

data class Position(val x: Int, val y: Int) {
    operator fun plus(other: Position): Position {
        return Position(x + other.x, y + other.y)
    }

    fun manhattan(): Int {
        return x + y
    }
}