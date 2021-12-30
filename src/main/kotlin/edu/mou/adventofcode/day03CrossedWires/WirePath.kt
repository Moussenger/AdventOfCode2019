package edu.mou.adventofcode.day03CrossedWires

data class WirePath(val path: MutableList<Position>) {
    fun add(movements: List<Movement>) {
        movements.map { add(it) }
    }

    fun steps(position: Position): Int {
        return path.indexOf(position)
    }

    fun intersections(otherWirePath: WirePath): List<Position> {
        return path.toSet().intersect(otherWirePath.path.toSet()).toMutableList().apply { remove(Position(0, 0)) }
    }

    private fun add(movement: Movement) {
        path.addAll(movement.move(last()))
    }

    private fun last(): Position {
        return path.last()
    }

}