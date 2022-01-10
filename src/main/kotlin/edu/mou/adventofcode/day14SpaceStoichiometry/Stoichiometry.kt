package edu.mou.adventofcode.day14SpaceStoichiometry

import kotlin.math.ceil
import kotlin.math.max

data class Stoichiometry(val reactives: Map<Reactive, List<Reactive>>) {
    private val keys: Set<Reactive> = reactives.keys

    companion object {
        val FUEL = Reactive("FUEL").apply { quantity = 1 }
        val ORE = Reactive("ORE")
    }

    fun getOREForFuel(
        reactive: Reactive = FUEL, multiplier: Long = 1, deposit: MutableMap<String, Long> = mutableMapOf()
    ): Long {
        return if (reactive.name == ORE.name) {
            multiplier
        } else {
            reactives[reactive]!!.sumOf {
                val currentDeposit = deposit.getOrDefault(it.name, 0)
                val quantityRequested = it.quantity * multiplier.toDouble()
                val quantityLeftInDeposit = max(currentDeposit - quantityRequested, 0.0).toLong()
                val realQuantity = max(quantityRequested - currentDeposit, 0.0)
                val unitQuantity = (keys.firstOrNull { key -> key.name == it.name }?.quantity ?: 1)
                val reactiveMultiplier = ceil(realQuantity / unitQuantity).toLong()

                deposit[it.name] = quantityLeftInDeposit + reactiveMultiplier * unitQuantity - realQuantity.toLong()

                getOREForFuel(it, reactiveMultiplier, deposit)
            }
        }
    }
}