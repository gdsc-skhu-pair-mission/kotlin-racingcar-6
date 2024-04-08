package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

const val MOVE_CONDITION: Int = 4

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val cars: MutableList<Car> = mutableListOf()
) {
    fun gameStart() {
        generateCars()
        val gameTimes: Int = inputView.inputGameTime()
        outputView.printRaceResultMessage()
        for (gameTime in 1..gameTimes) {
            updateCarsState()
            outputView.printRaceResult(cars)
        }
        outputView.printWinners(getWinnerNames())
    }

    private fun generateCars() {
        val carNames: List<String> = inputView.inputCarNames()
        carNames.forEach { cars.add(Car(it)) }
    }

    private fun updateCarsState() {
        cars.forEach { moveCarRandomlyIfConditionMet(it) }
    }

    private fun getWinnerNames(): List<String> {
        val sortedCar: List<Car> = cars.sortedByDescending { it.distance }
        val mostDistanceCar = sortedCar.first()
        return sortedCar.filter { it.distance == mostDistanceCar.distance }
            .map { it.name }
    }

    private fun moveCarRandomlyIfConditionMet(car: Car) {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= MOVE_CONDITION) {
            car.moveForward()
        }
    }

}