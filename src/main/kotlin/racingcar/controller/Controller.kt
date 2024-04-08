package racingcar.controller

import racingcar.model.Car
import racingcar.model.Racing
import racingcar.view.Input
import racingcar.view.Output

class Controller(
    private val input: Input,
    private val output: Output
) {
    private lateinit var racing: Racing

    fun play() {
        prepareRacing()
        processRacing()
        showWinners()
    }

    private fun prepareRacing() {
        output.printStartMessage()
        val cars = input.getCars()
        racing = Racing(cars.map { Car(it) })
    }

    private fun processRacing() {
        output.printAttemptMessage()
        val attempts = input.getAttempt()
        output.printResultMessage()
        repeat(attempts) {
            racing.playRound()
            showRoundResult()
        }
    }

    private fun showRoundResult() {
        racing.getCurrentRacingStates().forEach { racingDto ->
            output.printPosition(racingDto.name, racingDto.position)
        }
        println()
    }

    private fun showWinners() {
        val winners = racing.getWinners()
        output.printWinner(winners)
    }
}
