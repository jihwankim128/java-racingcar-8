package racingcar;

import racingcar.application.RacingCarController;
import racingcar.domain.MoveCondition;
import racingcar.domain.RandomMoveCondition;
import racingcar.ui.ConsoleInputView;
import racingcar.ui.ConsoleOutputView;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        MoveCondition moveCondition = new RandomMoveCondition();

        RacingCarController racingCarController = new RacingCarController(inputView, outputView, moveCondition);
        racingCarController.run();
    }
}
