package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.dto.RacingDto

class Racing(
    private val cars: List<Car>
) {
    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
        const val MIN_FORWARD_VALUE = 4
    }

    fun playRound() {
        cars.forEach { car ->
            car.moveForward(generateRandomNumber() >= MIN_FORWARD_VALUE)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    fun getCurrentRacingStates(): List<RacingDto> {
        return cars.map { car -> RacingDto(car.name, car.position) }
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
    }
}
