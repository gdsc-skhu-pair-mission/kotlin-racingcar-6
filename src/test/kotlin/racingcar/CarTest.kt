package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    fun `전진하는 경우`() {
        val car = Car("testCar",0)
        car.moveForward(true)
        assertEquals(1,car.position)

    }
    @Test
    fun `전진하는 않는 경우`() {
        val car = Car("testCar",0)
        car.moveForward(false)
        assertEquals(0,car.position)
    }
}

