package racingcar.application;

import java.util.List;
import racingcar.domain.MoveCondition;
import racingcar.domain.PlayResult;
import racingcar.domain.Players;
import racingcar.domain.Trial;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveCondition moveCondition;

    public RacingCarController(InputView inputView, OutputView outputView, MoveCondition moveCondition) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveCondition = moveCondition;
    }

    public void run() {
        List<String> carNames = inputView.readInputCarNames();
        Players players = new Players(carNames);

        int trialCount = inputView.readTrialCount();
        Trial trial = new Trial(trialCount);

        outputView.printRacingStarted();
        trial.tryAction(() -> {
            List<PlayResult> playResult = players.play(moveCondition);
            outputView.printTrialResult(playResult);
        });

        List<String> winners = players.getWinners();
        outputView.printWinners(winners);
    }
}
