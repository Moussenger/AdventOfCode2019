package edu.mou.adventofcode.tools.models

import kotlin.math.atan2

data class Point(val x: Int, val y: Int) {
    companion object {
        fun up() = Point(0, -1)
        fun right() = Point(1, 0)
        fun down() = Point(0, 1)
        fun left() = Point(-1, 0)
    }

    fun angleTo(other: Point): Double {
        return atan2((other.x - x).toDouble(), (other.y - y).toDouble())
    }

    fun squareDistanceTo(other: Point): Double {
        val deltaX = other.x - x.toDouble()
        val deltaY = other.y - y.toDouble()

        return deltaX * deltaX + deltaY * deltaY
    }

    operator fun plus(other: Point): Point {
        return copy(x = x + other.x, y = y + other.y)
    }
}

fun List<String>.toPoints(point: String): List<Point> {
    return flatMapIndexed { y, string ->
        string.toList().mapIndexedNotNull { x, value -> if (value.toString() == point) Point(x, y) else null }
    }
}