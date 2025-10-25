package racingcar;

import racingcar.adapter.external.RandomForwardCondition;
import racingcar.adapter.in.ConsoleRacingController;
import racingcar.adapter.in.InputView;
import racingcar.adapter.in.OutputView;
import racingcar.application.RacingCarUseCase;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarUseCase useCase = new RacingCarUseCase(new RandomForwardCondition());

        ConsoleRacingController controller = new ConsoleRacingController(inputView, outputView, useCase);
        controller.run();
    }
}
