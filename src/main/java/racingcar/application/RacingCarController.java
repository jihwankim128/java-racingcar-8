package racingcar.application;

import racingcar.domain.RacingEventListener;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final RacingEventListener eventListener;

    public RacingCarController(InputView inputView, RacingEventListener eventListener) {
        this.inputView = inputView;
        this.eventListener = eventListener;
    }

    public void run() {
        String carNames = inputView.readInputCarNames();
        int trialCount = inputView.readInputTryCount();

        RacingGame racingGame = new RacingGame(carNames, trialCount, eventListener);
        racingGame.play();
    }
}
