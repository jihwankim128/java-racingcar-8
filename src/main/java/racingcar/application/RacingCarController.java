package racingcar.application;

import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.Players;
import racingcar.domain.Trial;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.readInputCarNames();
        Players players = new Players(carNames);

        int trialCount = inputView.readTrialCount();
        Trial trial = new Trial(trialCount);

        outputView.printRacingStarted();
        trial.tryAction(() -> {
            List<Player> playResult = players.play();
            outputView.printTrialResult(playResult);
        });

        List<String> winners = players.getWinners();
        outputView.printWinners(winners);
    }
}
