package edu.mou.adventofcode.tools

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.test.assertEquals

abstract class DayProblemTest<T : DayProblem<P1, P2>, P1, P2>(
    private val dayProblem: KClass<T>,
    private val expectedPart1: P1,
    private val expectedPart2: P2,
    private val argsPart1: List<String> = listOf(),
    private val argsPart2: List<String> = listOf(),
) {
    @Test
    fun testPart1() {
        assertEquals(expectedPart1, dayProblem.createInstance().solvePart1(*argsPart1.toTypedArray()))
    }

    @Test
    fun testPart2() {
        assertEquals(expectedPart2, dayProblem.createInstance().solvePart2(*argsPart2.toTypedArray()))
    }
}