package racingcar.view

import racingcar.model.Car
const val MESSAGE_OF_RACE_RESULT: String = "실행 결과 "


object OutputView {
    fun printRaceResultMessage() {
        println()
        println(MESSAGE_OF_RACE_RESULT)
    }

    fun printRaceResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name.trim()} : ${"-".repeat(it.distance)}")
        }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("최종 우승자 : ${winnerNames.joinToString(", ")}")
    }

}