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
        RacingGame racingGame = new RacingGame(carNames);

        racingCarView.printInputTryCountPrompt();
        int tryCount = racingCarView.readInputTryCount();

        racingCarView.printRacingStart();
        List<RacingCar> result = racingGame.start(tryCount);
        racingCarView.printResultByRound(result);

        // TODO: 라운드 끝나고 최종 우승자 계산
        List<String> winners = racingGame.getWinners();
        racingCarView.printFinalResult(winners);
    }
}
