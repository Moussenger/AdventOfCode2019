package edu.mou.adventofcode.day12TheNBodyProblem

import edu.mou.adventofcode.tools.models.Point
import kotlin.math.absoluteValue

data class Moon(var position: Point, var velocity: Point = Point.unit()) {
    fun applyVelocity() {
        this.position += velocity
    }

    fun updateVelocity(delta: Point) {
        this.velocity += delta
    }

    fun energy(): Int {
        return potentialEnergy() * kineticEnergy()
    }

    private fun potentialEnergy(): Int {
        return position.x.absoluteValue + position.y.absoluteValue + position.z.absoluteValue
    }

    private fun kineticEnergy(): Int {
        return velocity.x.absoluteValue + velocity.y.absoluteValue + velocity.z.absoluteValue
    }
}