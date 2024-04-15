package racingcar.model

class Car(
    private val _name: String,
    private var _position: Int = ZERO
) {
    companion object {
        private const val ZERO = 0
    }

    val name: String
        get() = _name

    val position: Int
        get() = _position

    fun moveForward(shouldMove: Boolean) {
        if (shouldMove) {
            _position++
        }
    }
}
