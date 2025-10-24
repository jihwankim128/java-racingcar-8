package racingcar.application;

import java.util.List;
import racingcar.domain.MoveCondition;
import racingcar.domain.Race;
import racingcar.domain.Trial;
import racingcar.domain.vo.RaceResult;

public class RacingCarUseCase {

    private final MoveCondition moveCondition;

    public RacingCarUseCase(MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
    }

    public RacingResult startRacing(RacingCommand command) {
        Race race = new Race(command.carNames());
        Trial trial = new Trial(command.trialCount());

        List<List<RaceResult>> history = trial.tryAction(() -> {
            race.race(moveCondition);
            return race.getRaceResult();
        });

        List<String> winners = race.getWinners();
        return new RacingResult(history, winners);
    }
}
