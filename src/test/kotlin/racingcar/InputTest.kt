package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.view.InputView

class InputTest : NsTest() {
    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `참여자 이름으로 자동차 생성`(participant: String) {
        val car = Car(participant)
        Assertions.assertNotNull(car)
        Assertions.assertEquals(participant, car.name)
    }
    @ParameterizedTest
    @ValueSource(strings = ["pobiiii", "woniii"])
    fun `참여자의 이름은 5자 이하야 한다`(input: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Car(name = input)
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["pobi,pobi"])
    fun `자동차의 이름은 중복될 수 없다`(input: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Car(name = input)
        }
    }
    @Test
    fun `자동차는 두 대 이상 있어야한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["0", "woni"])
    fun `게임 횟수는 정수여야한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "woni") }
        }
    }
    public override fun runMain() {
        main()
    }
}
