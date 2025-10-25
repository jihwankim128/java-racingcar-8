package racingcar.application;

import java.util.List;
import racingcar.domain.Attempts;
import racingcar.domain.ForwardCondition;
import racingcar.domain.RacingGame;
import racingcar.domain.vo.RaceResult;

public class RacingCarUseCase {

    private final ForwardCondition forwardCondition;

    public RacingCarUseCase(ForwardCondition forwardCondition) {
        this.forwardCondition = forwardCondition;
    }

    public RacingResult startRacing(RacingCommand command) {
        RacingGame racingGame = new RacingGame(command.carNames());
        Attempts attempts = new Attempts(command.attemptCount());

        List<List<RaceResult>> history = simulateRacing(racingGame, attempts);
        List<String> winners = racingGame.getWinners();

        return new RacingResult(history, winners);
    }

    private List<List<RaceResult>> simulateRacing(RacingGame racingGame, Attempts attempts) {
        return attempts.repeat(() -> {
            racingGame.play(forwardCondition);
            return racingGame.getRaceResult();
        });
    }
}
