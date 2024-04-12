package racingcar.model

class Car(
    private val _name: String,
    private val _position: Int = ZERO
) {
    companion object {
        const val ZERO = 0
    }

    val name: String
        get() = _name

    var position: Int
        get() = _position
        set(value) {}

   fun moveForward(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }
}
