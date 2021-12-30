package edu.mou.adventofcode.tools

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.test.assertEquals

abstract class DayProblemTest<T : DayProblem<P1, P2>, P1, P2>(
    private val dayProblem: KClass<T>,
    private val expectedPart1: P1,
    private val expectedPart2: P2
) {
    @Test
    fun testPart1() {
        assertEquals(dayProblem.createInstance().solvePart1(), expectedPart1)
    }

    @Test
    fun testPart2() {
        assertEquals(dayProblem.createInstance().solvePart2(), expectedPart2)
    }
}