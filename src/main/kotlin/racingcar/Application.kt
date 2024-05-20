package racingcar

import racingcar.controller.Controller
import racingcar.view.Input
import racingcar.view.Output

fun main() {
    val controller = Controller(Input(), Output())
    controller.play()
}
