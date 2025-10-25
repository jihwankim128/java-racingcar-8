package racingcar.application;

import java.util.List;
import racingcar.domain.ForwardCondition;
import racingcar.domain.Race;
import racingcar.domain.Trial;
import racingcar.domain.vo.RaceResult;

public class RacingCarUseCase {

    private final ForwardCondition forwardCondition;

    public RacingCarUseCase(ForwardCondition forwardCondition) {
        this.forwardCondition = forwardCondition;
    }

    public RacingResult startRacing(RacingCommand command) {
        Race race = new Race(command.carNames());
        Trial trial = new Trial(command.trialCount());

        List<List<RaceResult>> history = simulateRacing(race, trial);
        List<String> winners = race.getWinners();

        return new RacingResult(history, winners);
    }

    private List<List<RaceResult>> simulateRacing(Race race, Trial trial) {
        return trial.tryAction(() -> {
            race.play(forwardCondition);
            return race.getRaceResult();
        });
    }
}
