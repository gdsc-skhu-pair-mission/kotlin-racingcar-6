package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.view.OutputView

class ApplicationTest : NsTest() {
    @Test
    fun `전진 테스트`() {
        val car = Car("pobi")
        assertThat(car.distance).isEqualTo(0)
        car.moveForward()
        assertThat(car.distance).isEqualTo(1)
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
    @Test
    fun `자동차의 이름은 중복될 수 없다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }
    @Test
    fun `자동차는 두 대 이상 있어야한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["0", "woni"])
    fun `게임 횟수는 1 이상의 정수여야한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, woni", "-1") }
        }
    }
    @Test
    fun `레이싱 결과 출력`() {
        val outputView = OutputView()
        val car1 = Car("car1", 1)
        val car2 = Car("car2", 1)
        val car3 = Car("car3", 2)
        val cars = listOf(car1, car2, car3)
        outputView.printRaceResult(cars)
    }
    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
