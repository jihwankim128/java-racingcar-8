package racingcar.application;

import java.util.List;
import racingcar.domain.RacingEventListener;
import racingcar.domain.RacingGame;
import racingcar.ui.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final RacingEventListener eventListener;

    public RacingCarController(RacingCarView racingCarView, RacingEventListener eventListener) {
        this.racingCarView = racingCarView;
        this.eventListener = eventListener;
    }

    public void run() {
        racingCarView.printInputCarNamesPrompt();
        String carNames = racingCarView.readInputCarNames();
        racingCarView.printInputTryCountPrompt();
        int trialCount = racingCarView.readInputTryCount();

        RacingGame racingGame = new RacingGame(carNames, trialCount, eventListener);
        racingGame.play();

        List<String> winners = racingGame.getWinners();
        racingCarView.printFinalResult(winners);
    }
}
