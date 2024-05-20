package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.dto.RacingDto
import racingcar.model.Car
import racingcar.model.Racing
class RacingTest {
    @Test
    fun `모든 car의 현재 위치 확인`() {
        val car1 = Car("testCar1")
        val car2 = Car("testCar2")
        val racing = Racing(listOf(car1, car2))
        val states = racing.getCurrentRacingStates()

        assertEquals(2, states.size)
        assertEquals(RacingDto("testCar1", 0), states[0])
        assertEquals(RacingDto("testCar2", 0), states[1])
    }

    @Test
    fun `car가 한번 전진하고 현재 위치 확인`() {
        val car1 = Car("testCar1")
        val racing = Racing(listOf(car1))
        car1.moveForward(true)

        val states = racing.getCurrentRacingStates()

        assertEquals(1, states.size)
        assertEquals(RacingDto("testCar1", 1), states[0])
    }

    @Test
    fun `라운드가 시작되는지 확인`() {
        //playRound 에 대한 테스트
    }
}
