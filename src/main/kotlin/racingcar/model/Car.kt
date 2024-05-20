package racingcar.model

class Car(
    val name: String
) {
    companion object {
        const val ZERO = 0
    }

    private var _position: Int = ZERO
    val position: Int
        get() = _position

   fun moveForward(shouldMove: Boolean) {
        if (shouldMove) {
            _position++
        }
    }
}
