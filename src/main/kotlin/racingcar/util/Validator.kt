package racingcar.util

object Validator {
    private const val MIN_ATTEMPT = 1
    private const val MIN_CAR_COUNT = 2
    private const val MAX_CAR_LENGTH = 5
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
        require(input.size >= MIN_CAR_COUNT) {
            val countError = CountError()
            countError
        }
    }

    private fun validateDuplicate(input: List<String>) {
        require(input.distinct().size == input.size) {
            val duplicateError = DuplicateError()
            duplicateError
        }
    }

    private fun validateLength(input: String) {
        require(input.length <= MAX_CAR_LENGTH) {
            val lengthError = LengthError()
            lengthError
        }
    }

    private fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            val inputError = InputError()
            inputError
        }
    }

    private fun validateNumber(input: String) {
        require(input.all { it.isDigit() }) {
            val attemptsError = AttemptsError()
            attemptsError
        }
    }

    private fun validateValue(input: String) {
        require(input.toInt() >= MIN_ATTEMPT) {
            val valueError = ValueError()
            valueError
        }
    }
}
