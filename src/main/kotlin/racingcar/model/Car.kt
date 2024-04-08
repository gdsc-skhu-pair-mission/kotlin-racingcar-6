package racingcar.model

const val MAX_NAME_LENGTH = 5
const val MIN_NAME_LENGTH = 1

class Car(
    val name: String,
    var distance: Int = 0
) {
    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            IllegalArgumentException("이름은 ${MIN_NAME_LENGTH}자 이상, ${MAX_NAME_LENGTH}자 이하만 가능합니다.")
        }
    }
    fun moveForward() {
        distance++
    }
}
