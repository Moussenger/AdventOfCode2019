package edu.mou.adventofcode.day07AmplificationCircuit

data class AmplifierCircuit(val amplifiers: List<Amplifier>) {
    fun run(): Int {
        var nextSignal = 0

        while (!amplifiers.last().isHalted()) {
            for (amplifier in amplifiers) {
                nextSignal = amplifier.run(nextSignal)
            }
        }

        return nextSignal
    }
}