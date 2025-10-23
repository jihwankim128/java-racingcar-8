package racingcar;

import racingcar.application.RacingCarController;
import racingcar.ui.ConsoleInputView;
import racingcar.ui.ConsoleOutputView;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        RacingCarController racingCarController = new RacingCarController(inputView, outputView);
        racingCarController.run();
    }
}
