package edu.mou.adventofcode.day03CrossedWires

data class Movement(val deltaX: Int, val deltaY: Int) {
    companion object {
        fun parse(movement: String): Movement {
            val operator = movement.take(1)
            val amount = movement.substring(1).toInt().run { if (operator in listOf("L", "D")) -this else this }

            return if (operator in listOf("R", "L")) Movement(amount, 0) else Movement(0, amount)
        }
    }

    fun move(position: Position): List<Position> {
        val target = position + Position(x = deltaX, y = deltaY)

        return if (deltaX != 0) {
            val range = if (position.x < target.x) position.x + 1..target.x else (position.x - 1).downTo(target.x)
            range.map { Position(x = it, y = position.y) }
        } else {
            val range = if (position.y < target.y) position.y + 1..target.y else (position.y - 1).downTo(target.y)
            range.map { Position(x = position.x, y = it) }
        }

    }
}