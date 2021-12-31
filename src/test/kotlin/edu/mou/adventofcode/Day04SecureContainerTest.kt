package edu.mou.adventofcode

import edu.mou.adventofcode.day04SecureContainer.Day04SecureContainer
import edu.mou.adventofcode.tools.DayProblemTest

class Day04SecureContainerTest :
    DayProblemTest<Day04SecureContainer, Int, Int>(
        dayProblem = Day04SecureContainer::class,
        expectedPart1 = 18,
        expectedPart2 = 17
    )