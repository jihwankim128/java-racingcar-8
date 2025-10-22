package racingcar.application;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.ui.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void run() {
        racingCarView.printInputCarNamesPrompt();
        String carNames = racingCarView.readInputCarNames();
        racingCarView.printInputTryCountPrompt();
        int trialCount = racingCarView.readInputTryCount();

        RacingGame racingGame = new RacingGame(carNames, trialCount);


        racingCarView.printRacingStart();
        while (racingGame.canStart()) {
            List<RacingCar> result = racingGame.start();
            racingCarView.printTrialResult(result);
        }

        List<String> winners = racingGame.getWinners();
        racingCarView.printFinalResult(winners);
    }
}
