package racingcar;

import racingcar.application.RacingCarController;
import racingcar.domain.RacingEventListener;
import racingcar.infrastructure.ConsoleOutputListener;
import racingcar.ui.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingEventListener eventListener = new ConsoleOutputListener(racingCarView);
        RacingCarController racingCarController = new RacingCarController(racingCarView, eventListener);
        racingCarController.run();
    }
}
