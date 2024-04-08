package racingcar.view
import camp.nextstep.edu.missionutils.Console

const val MESSAGE_OF_INPUT_CAR_NAMES: String = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)"
const val MESSAGE_OF_INPUT_GAME_TIME: String = "시도할 횟수는 몇 회인가요?"
const val MINIMUM_NUMBER_OF_CARS: Int = 2


object InputView {
    fun inputCarNames(): List<String> {
        println(MESSAGE_OF_INPUT_CAR_NAMES)
        val cars: List<String> = Console.readLine().split(",")

        require(cars.size > 1) {
            IllegalArgumentException("자동차는 ${MINIMUM_NUMBER_OF_CARS}대 이상이어야 합니다.")
        }
        require(cars.distinct().size == cars.size) {
            IllegalArgumentException("자동차 이름은 중복되면 안됩니다.")
        }

        return cars
    }

    fun inputGameTime(): Int {
        println(MESSAGE_OF_INPUT_GAME_TIME)
        val gameTime = Console.readLine().toInt()

        require(gameTime > 0) {
            IllegalArgumentException("게임 횟수는 1 이상의 정수여야 합니다.")
        }

        return gameTime
    }

}