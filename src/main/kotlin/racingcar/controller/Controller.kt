package racingcar.controller

import racingcar.model.Car
import racingcar.model.Racing
import racingcar.view.Input
import racingcar.view.Output

class Controller(
    private val input: Input,
    private val output: Output,
) {
 //   private val cars = listOf<Car>()
    private lateinit var racing: Racing

    fun play() {
        prepareRacing()
        initRacing()
        processRacing()
        showWinners()
    }

    private fun prepareRacing() {
        output.printStartMessage()
    }

    private fun initRacing(){
        val carNames = input.getCars()
        val cars = carNames.map { Car(it) }
        racing = Racing(cars)
    }

    fun getWinners(): List<String> {
        val maxPosition: Int = racing.getCurrentRacingStates().maxOf { it.position }
        return racing.getCurrentRacingStates().filter { it.position == maxPosition }.map { it.name }
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
        val winners = getWinners()
        output.printWinner(winners)
    }
}
