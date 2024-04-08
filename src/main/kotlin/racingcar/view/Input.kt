package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator.validateAttempt
import racingcar.util.Validator.validateCar

class Input {
    companion object {
        const val DELIMITER = ","
    }

    private fun getUserInput(): String = Console.readLine()

    fun getCars(): List<String> {
        val cars = getUserInput().split(DELIMITER)
        validateCar(cars)
        return cars
    }

    fun getAttempt(): Int {
        val attempt = getUserInput()
        validateAttempt(attempt)
        return attempt.toInt()
    }
}