package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Validator

class ValidateTest {
    @Test
    fun `자동차 이름이 중복되면 예외가 발생한다`() {
        val input = listOf("car", "car")
        assertThrows<IllegalArgumentException> {
            Validator.validateCar(input)
        }
    }

    @Test
    fun `자동차 이름의 길이가 5를 초과하면 예외가 발생한다`() {
        val input = listOf("longname", "car")
        assertThrows<IllegalArgumentException> {
            Validator.validateCar(input)
        }
    }

    @Test
    fun `자동차 이름이 비어있으면 예외가 발생한다`() {
        val input = listOf("", "car")
        assertThrows<IllegalArgumentException> {
            Validator.validateCar(input)
        }
    }

    @Test
    fun `자동차의 수가 2 미만이면 예외가 발생한다`() {
        val input = listOf("car")
        assertThrows<IllegalArgumentException> {
            Validator.validateCar(input)
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        val input = "notANumber"
        assertThrows<IllegalArgumentException> {
            Validator.validateAttempt(input)
        }
    }

    @Test
    fun `시도 횟수가 1 미만이면 예외가 발생한다`() {
        val input = "0"
        assertThrows<IllegalArgumentException> {
            Validator.validateAttempt(input)
        }
    }
}
