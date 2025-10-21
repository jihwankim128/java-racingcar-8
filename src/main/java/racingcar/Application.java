package racingcar;

import racingcar.application.RacingCarController;
import racingcar.ui.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingCarController racingCarController = new RacingCarController(racingCarView);
        racingCarController.run();
    }
}
