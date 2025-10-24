package racingcar;

import racingcar.adapter.in.ConsoleRacingController;
import racingcar.adapter.in.InputView;
import racingcar.adapter.in.OutputView;
import racingcar.application.RacingCarUseCase;
import racingcar.domain.MoveCondition;
import racingcar.domain.RandomMoveCondition;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveCondition moveCondition = new RandomMoveCondition();
        RacingCarUseCase useCase = new RacingCarUseCase(moveCondition);

        ConsoleRacingController controller = new ConsoleRacingController(inputView, outputView, useCase);
        controller.run();
    }
}
