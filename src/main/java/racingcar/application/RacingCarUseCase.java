package racingcar.application;

import java.util.List;
import racingcar.domain.ForwardCondition;
import racingcar.domain.RacingGame;
import racingcar.domain.Trial;
import racingcar.domain.vo.RaceResult;

public class RacingCarUseCase {

    private final ForwardCondition forwardCondition;

    public RacingCarUseCase(ForwardCondition forwardCondition) {
        this.forwardCondition = forwardCondition;
    }

    public RacingResult startRacing(RacingCommand command) {
        RacingGame racingGame = new RacingGame(command.carNames());
        Trial trial = new Trial(command.trialCount());

        List<List<RaceResult>> history = simulateRacing(racingGame, trial);
        List<String> winners = racingGame.getWinners();

        return new RacingResult(history, winners);
    }

    private List<List<RaceResult>> simulateRacing(RacingGame racingGame, Trial trial) {
        return trial.tryAction(() -> {
            racingGame.play(forwardCondition);
            return racingGame.getRaceResult();
        });
    }
}
