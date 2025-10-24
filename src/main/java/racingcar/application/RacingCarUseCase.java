package racingcar.application;

import java.util.List;
import racingcar.domain.MoveCondition;
import racingcar.domain.Players;
import racingcar.domain.Trial;
import racingcar.domain.vo.PlayResult;

public class RacingCarUseCase {

    private final MoveCondition moveCondition;

    public RacingCarUseCase(MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
    }

    public RacingResult startRacing(RacingCommand command) {
        Players players = new Players(command.carNames());
        Trial trial = new Trial(command.trialCount());

        List<List<PlayResult>> history = trial.tryAction(() -> {
            players.race(moveCondition);
            return players.getRaceResult();
        });

        List<String> winners = players.getWinners();
        return new RacingResult(history, winners);
    }
}
