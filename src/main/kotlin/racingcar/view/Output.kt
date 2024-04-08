package racingcar.view

class Output {
    companion object {
        const val START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val RESULT_MESSAGE = "실행 결과"
        const val COLON = " : "
        const val POSITION_SIGN = "-"
        const val SEPARATOR = ", "
    }

    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printAttemptMessage() {
        println(ATTEMPT_MESSAGE)
    }

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printPosition(car: String, position: Int) {
        println("$car$COLON" + POSITION_SIGN.repeat(position))
    }

    fun printWinner(winner: List<String>) {
        val result = winner.joinToString(SEPARATOR)
    }
}