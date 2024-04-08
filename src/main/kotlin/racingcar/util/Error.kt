package racingcar.util

enum class Error(private val message: String) {
    INPUT_ERROR("올바르지 않은 입력입니다."),
    LENGTH_ERROR("자동차 이름은 5자 이하여야 합니다."),
    DUPLICATE_ERROR("중복되는 자동차가 존재합니다."),
    COUNT_ERROR("자동차는 2대 이상이어야 합니다."),
    ATTEMPTS_ERROR("횟수는 숫자여야 합니다."),
    VALUE_ERROR("횟수는 1 이상이어야 합니다.");

    fun getMessage(): String = "[ERROR] $message"
}