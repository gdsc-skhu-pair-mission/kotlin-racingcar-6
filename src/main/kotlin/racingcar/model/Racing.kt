package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.dto.RacingDto

class Racing(
    private val cars: List<Car>
) {
    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
    }

    fun playRound() {
        cars.forEach { car ->
            car.moveForward(generateRandomNumber())
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
