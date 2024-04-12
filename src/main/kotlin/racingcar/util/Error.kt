package racingcar.util

import org.assertj.core.internal.ErrorMessages
import org.mockito.internal.invocation.RealMethod.IsIllegal
import java.lang.IllegalArgumentException

open class Error(val message: String) {
    open fun getMessage() {
        println("[Error] $message")
    }
}

class InputError() : Error("올바르지 않은 입력입니다.")

class LengthError() : Error("자동차 이름은 5자 이하여야 합니다.")

class DuplicateError() : Error("중복되는 자동차가 존재합니다.")

class CountError() : Error("자동차는 2대 이상이어야 합니다.")

class AttemptsError() : Error("횟수는 숫자여야 합니다.")

class ValueError() : Error("횟수는 1 이상이어야 합니다.")
