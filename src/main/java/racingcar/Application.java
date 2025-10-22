package racingcar;

import racingcar.application.RacingCarController;
import racingcar.domain.RacingEventListener;
import racingcar.infrastructure.ConsoleOutputListener;
import racingcar.ui.ConsoleInputView;
import racingcar.ui.ConsoleOutputView;
import racingcar.ui.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        RacingEventListener eventListener = new ConsoleOutputListener(new ConsoleOutputView());
        RacingCarController racingCarController = new RacingCarController(inputView, eventListener);
        racingCarController.run();
    }
}
