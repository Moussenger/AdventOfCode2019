package edu.mou.adventofcode.tools

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor
import kotlin.test.assertEquals

abstract class DayProblemTest<T : DayProblem<P1, P2>, P1, P2>(
    private val dayProblem: KClass<T>,
    private val expectedPart1: P1,
    private val expectedPart2: P2,
    private val argsPart1: List<String> = listOf(),
    private val argsPart2: List<String> = listOf(),
    private val inputPart1: String? = null,
    private val inputPart2: String? = null
) {
    @Test
    fun testPart1() {
        val constructor = dayProblem.primaryConstructor!!
        val instance = if (inputPart1 == null) dayProblem.createInstance() else constructor.call(inputPart1)
        assertEquals(expectedPart1, instance.solvePart1(*argsPart1.toTypedArray()))
    }

    @Test
    fun testPart2() {
        val constructor = dayProblem.primaryConstructor!!
        val instance = if (inputPart2 == null) dayProblem.createInstance() else constructor.call(inputPart2)
        assertEquals(expectedPart2, instance.solvePart2(*argsPart2.toTypedArray()))
    }
}