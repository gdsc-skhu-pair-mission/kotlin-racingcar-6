package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    @DisplayName("난수가 4 이상인 경우 자동차는 전진한다.")
    fun forwardTest() {
        val car = Car("testCar",0)
        car.moveForward(4)
        assertEquals(1,car.position)
    }
    @Test
    @DisplayName("난수가 4 미만인 경우 자동차는 전진하지 않는다.")
    fun stopTest() {
        val car = Car("testCar",0)
        car.moveForward(3)
        assertEquals(0,car.position)
    }
}
