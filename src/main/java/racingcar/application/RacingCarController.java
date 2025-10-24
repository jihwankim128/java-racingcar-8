package racingcar.application;

import java.util.List;
import racingcar.domain.MoveCondition;
import racingcar.domain.Player;
import racingcar.domain.Players;
import racingcar.domain.Trial;

public class RacingCarController {

    private final InputReader inputReader;
    private final OutputReader outputReader;
    private final MoveCondition moveCondition;

    public RacingCarController(InputReader inputReader, OutputReader outputReader, MoveCondition moveCondition) {
        this.inputReader = inputReader;
        this.outputReader = outputReader;
        this.moveCondition = moveCondition;
    }

    public void run() {
        List<String> carNames = inputReader.readInputCarNames();
        Players players = new Players(carNames);

        int trialCount = inputReader.readTrialCount();
        Trial trial = new Trial(trialCount);

        outputReader.printRacingStarted();
        trial.tryAction(() -> {
            List<Player> playResult = players.play(moveCondition);
            List<PlayResult> result = playResult.stream().map(PlayResult::from).toList();
            outputReader.printTrialResult(result);
        });

        List<String> winners = players.getWinners();
        outputReader.printWinners(winners);
    }
}
