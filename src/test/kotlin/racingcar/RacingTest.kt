package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import racingcar.controller.Controller
import racingcar.dto.RacingDto
import racingcar.model.Car
import racingcar.model.Racing
import racingcar.view.Input
import racingcar.view.Output

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

//    @Test
//    fun `우승자의 이름이 잘 나오는지 확인`() {
//        val car1 = Car("testCar1", 5)
//        val car2 = Car("testCar2", 3)
//        val car3 = Car("testCar3", 5)
//        val racing = Racing(listOf(car1, car2, car3))
//
//        val winners = racing.getWinners()
//
//        assertEquals(2, winners.size)
//        assertTrue(winners.containsAll(listOf("testCar1", "testCar3")))
//    }

}
