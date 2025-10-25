package racingcar;

import racingcar.adapter.in.ConsoleRacingController;
import racingcar.adapter.in.InputView;
import racingcar.adapter.in.OutputView;
import racingcar.adapter.out.RandomForwardCondition;
import racingcar.application.RacingCarUseCase;
import racingcar.domain.ForwardCondition;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ForwardCondition condition = new RandomForwardCondition();
        RacingCarUseCase useCase = new RacingCarUseCase(condition);

        ConsoleRacingController controller = new ConsoleRacingController(inputView, outputView, useCase);
        controller.run();
    }
}
