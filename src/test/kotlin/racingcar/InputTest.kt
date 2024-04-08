package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class InputTest : NsTest() {
    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `참여자 이름으로 자동차 생성`(participant: String) {
        val car = Car(participant)
        Assertions.assertNotNull(car)
        Assertions.assertEquals(participant, car.name)
    }
    @Test
    fun `참여자의 이름은 5자 이하야한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaii", "1") }
        }
    }
    @Test
    fun `자동차의 이름은 중복될 수 없다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }
    public override fun runMain() {
        main()
    }
}
