package racingcar

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import racingcar.view.Output

class OutputTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    @DisplayName("시작 메시지 출력 테스트")
    fun `printStartMessage() should print start message`() {
        Output.printStartMessage()
        assertEquals(Output.START_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    @DisplayName("시도 횟수 요청 메시지 출력 테스트")
    fun `printAttemptMessage() should print attempt message`() {
        Output.printAttemptMessage()
        assertEquals(Output.ATTEMPT_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    @DisplayName("실행 결과 메시지 출력 테스트")
    fun `printResultMessage() should print result message`() {
        Output.printResultMessage()
        assertEquals(System.lineSeparator() + Output.RESULT_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    @DisplayName("자동차 위치 출력 테스트")
    fun `printPosition() should print car name, position signs`() {
        val car = "pobi"
        val position = 3
        Output.printPosition(car, position)
        assertEquals("$car${Output.COLON}${Output.POSITION_SIGN.repeat(position)}" + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트")
    fun `printWinner() should print winner message followed by winner names separated by comma`() {
        val winners = listOf("pobi", "jun")
        Output.printWinner(winners)
        assertEquals("${Output.WINNER_MESSAGE}${winners.joinToString(Output.SEPARATOR)}", outputStreamCaptor.toString())
    }
}
