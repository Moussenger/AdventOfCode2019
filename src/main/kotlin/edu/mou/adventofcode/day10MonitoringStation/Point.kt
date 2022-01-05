package edu.mou.adventofcode.day10MonitoringStation

import kotlin.math.atan2

data class Point(val x: Int, val y: Int) {
    fun angleTo(other: Point): Double {
        return atan2((other.x - x).toDouble(), (other.y - y).toDouble())
    }

    fun squareDistanceTo(other: Point): Double {
        val deltaX = other.x - x.toDouble()
        val deltaY = other.y - y.toDouble()

        return deltaX * deltaX + deltaY * deltaY
    }
}

fun List<String>.toPoints(point: String): List<Point> {
    return flatMapIndexed { y, string ->
        string.toList().mapIndexedNotNull { x, value -> if (value.toString() == point) Point(x, y) else null }
    }
}