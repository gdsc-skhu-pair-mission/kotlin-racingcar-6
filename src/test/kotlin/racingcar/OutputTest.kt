package racingcar

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import racingcar.view.Output

class OutputTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val output = Output()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `시작 메시지 출력 테스트`() {
        output.printStartMessage()
        assertEquals(Output.START_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    fun `시도 횟수 요청 메시지 출력 테스트`() {
        output.printAttemptMessage()
        assertEquals(Output.ATTEMPT_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    fun `실행 결과 메시지 출력 테스트`() {
        output.printResultMessage()
        assertEquals(System.lineSeparator() + Output.RESULT_MESSAGE + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    fun `자동차 위치 출력 테스트`() {
        val car = "pobi"
        val position = 3
        output.printPosition(car, position)
        assertEquals("$car${Output.COLON}${Output.POSITION_SIGN.repeat(position)}" + System.lineSeparator(), outputStreamCaptor.toString())
    }

    @Test
    fun `최종 우승자 출력 테스트`() {
        val winners = listOf("pobi", "jun")
        output.printWinner(winners)
        assertEquals("${Output.WINNER_MESSAGE}${winners.joinToString(Output.SEPARATOR)}", outputStreamCaptor.toString())
    }
}
