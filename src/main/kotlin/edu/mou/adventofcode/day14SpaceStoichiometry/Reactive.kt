package edu.mou.adventofcode.day14SpaceStoichiometry

import kotlin.properties.Delegates

data class Reactive(val name: String) {
    var quantity by Delegates.notNull<Int>()
}