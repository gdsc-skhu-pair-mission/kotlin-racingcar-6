package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator.validateAttempt
import racingcar.util.Validator.validateCar

class Input {
    companion object {
        const val DELIMITER = ","
    }

    fun getUserInputAsString(): String = Console.readLine()


// 이거에 대한 cars에 리스트가
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
