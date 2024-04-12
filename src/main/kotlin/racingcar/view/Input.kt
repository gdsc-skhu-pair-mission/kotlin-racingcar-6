package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator.validateAttempt
import racingcar.util.Validator.validateCar

class Input {
    companion object {
        const val DELIMITER = ","
    }

    private fun getUserInputAsString(): String = Console.readLine()

    fun getCars(): List<String> {
        val cars = getUserInputAsString().split(DELIMITER)
        validateCar(cars)
        return cars
    }

    fun getAttempt(): Int {
        val attempt = getUserInputAsString()
        validateAttempt(attempt)
        return attempt.toInt()
    }
}
