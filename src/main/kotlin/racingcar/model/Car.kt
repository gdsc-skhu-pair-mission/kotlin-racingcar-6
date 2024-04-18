package racingcar.model

class Car(
    private val _name: String,
    private var _position: Int = ZERO
) {
    companion object {
        private const val ZERO = 0
        private const val MIN_FORWARD_VALUE = 4
    }

    val name: String
        get() = _name

    val position: Int
        get() = _position

    fun moveForward(randomNumber: Int) {
        if (randomNumber >= MIN_FORWARD_VALUE) {
            _position++
        }
    }
}
