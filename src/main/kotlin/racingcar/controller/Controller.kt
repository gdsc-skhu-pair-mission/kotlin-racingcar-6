package racingcar.controller

import racingcar.model.Car
import racingcar.model.Racing
import racingcar.view.Input
import racingcar.view.Output

class Controller {
    fun play() {
        Output.printStartMessage()
        val cars = Input.getCars()
        val racing = Racing(cars.map { Car(it) })
        processRacing(racing)
        showWinners(racing)
    }

    private fun processRacing(racing: Racing) {
        Output.printAttemptMessage()
        val attempts = Input.getAttempt()
        Output.printResultMessage()
        repeat(attempts) {
            racing.playRound()
            showRoundResult(racing)
        }
    }

    private fun showRoundResult(racing: Racing) {
        racing.getCurrentRacingStates().forEach { racingDto ->
            Output.printPosition(racingDto.name, racingDto.position)
        }
        println()
    }

    private fun showWinners(racing: Racing) {
        val winners = racing.getWinners()
        Output.printWinner(winners)
    }
}
