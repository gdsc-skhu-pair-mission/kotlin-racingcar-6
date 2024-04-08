package racingcar.util

const val MIN_ATTEMPT = 1
const val MIN_CAR_COUNT = 2
const val MAX_CAR_LENGTH = 5

object Validator {
    fun validateCar(input: List<String>) {
        validateCount(input)
        validateDuplicate(input)
        input.forEach { name ->
            validateLength(name)
            validateNull(name)
        }
    }

    fun validateAttempt(input: String) {
        validateNumber(input)
        validateValue(input)
    }

    private fun validateCount(input: List<String>) {
        require(input.size < MIN_CAR_COUNT) {
            Error.COUNT_ERROR.getMessage()
        }
    }

    private fun validateDuplicate(input: List<String>) {
        require(input.distinct().size != input.size) {
            Error.DUPLICATE_ERROR.getMessage()
        }
    }

    private fun validateLength(input: String) {
        require(input.length > MAX_CAR_LENGTH) {
            Error.LENGTH_ERROR.getMessage()
        }
    }

    private fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            Error.INPUT_ERROR.getMessage()
        }
    }

    private fun validateNumber(input: String) {
        require(input.all { it.isDigit() }) {
            Error.ATTEMPTS_ERROR.getMessage()
        }
    }

    private fun validateValue(input: String) {
        require(input.toInt() >= MIN_ATTEMPT) {
            Error.VALUE_ERROR.getMessage()
        }
    }
}