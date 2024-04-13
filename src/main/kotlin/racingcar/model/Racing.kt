package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.dto.RacingDto

class Racing(//Racing에 빈칸으로 들어가는거 같음 cars를 넣어주는 부분이 필요 ?

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
        //    print(generateRandomNumber())
          }
    }

    fun getCurrentRacingStates(): List<RacingDto> {
        return cars.map { car -> RacingDto(car.name, car.position) }
    }

    private fun generateRandomNumber(): Int {
     //   println(generateRandomNumber())
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
    }
}
