package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class ApplicationTest : NsTest() {
    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `참여자 이름으로 차 생성`(participant: String) {
        val car = Car(participant)
        Assertions.assertNotNull(car)
        Assertions.assertEquals(participant, car.name)
    }
    @Test
    fun `전진 테스트`() {
        val car = Car("pobi")
        assertThat(car.distance).isEqualTo(0)
        car.moveForward()
        assertThat(car.distance).isEqualTo(1)
    }
    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }



    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
