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
    fun `참여자 이름으로 차 생성`(participant: String) {
        val car = Car(participant)
        Assertions.assertNotNull(car)
        Assertions.assertEquals(participant, car.name)
    }
    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }
    public override fun runMain() {
        main()
    }
}
