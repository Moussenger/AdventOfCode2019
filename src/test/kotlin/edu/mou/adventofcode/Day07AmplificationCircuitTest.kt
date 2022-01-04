package edu.mou.adventofcode

import edu.mou.adventofcode.day07AmplificationCircuit.Day07AmplificationCircuit
import edu.mou.adventofcode.tools.DayProblemTest

class Day07AmplificationCircuitTest :
    DayProblemTest<Day07AmplificationCircuit, Long, Long>(
        dayProblem = Day07AmplificationCircuit::class,
        expectedPart1 = 65210,
        argsPart1 = listOf("0", "4"),
        expectedPart2 = 18216,
        argsPart2 = listOf("5", "9"),
        inputPart2 = "input2.txt"
    )