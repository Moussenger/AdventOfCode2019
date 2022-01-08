package edu.mou.adventofcode

import edu.mou.adventofcode.day11SpacePolice.Day11SpacePolice
import edu.mou.adventofcode.tools.DayProblemTest

class Day11SpacePoliceTest :
    DayProblemTest<Day11SpacePolice, Int, String>(
        dayProblem = Day11SpacePolice::class,
        expectedPart1 = 2160,
        expectedPart2 = "\n" +
                " #    ###  #### ####  ##   ##  #### ####   \n" +
                " #    #  #    # #    #  # #  # #    #      \n" +
                " #    #  #   #  ###  #    #    ###  ###    \n" +
                " #    ###   #   #    #    # ## #    #      \n" +
                " #    # #  #    #    #  # #  # #    #      \n" +
                " #### #  # #### ####  ##   ### #    ####   ",
    )