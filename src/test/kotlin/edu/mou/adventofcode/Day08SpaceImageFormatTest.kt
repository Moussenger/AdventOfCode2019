package edu.mou.adventofcode

import edu.mou.adventofcode.day08SpaceImageFormat.Day08SpaceImageFormat
import edu.mou.adventofcode.tools.DayProblemTest

class Day08SpaceImageFormatTest :
    DayProblemTest<Day08SpaceImageFormat, Int, String>(
        dayProblem = Day08SpaceImageFormat::class,
        expectedPart1 = 1,
        argsPart1 = listOf("3", "2"),
        expectedPart2 = "\n #\n# ",
        argsPart2 = listOf("2", "2"),
        inputPart2 = "input2.txt"
    )