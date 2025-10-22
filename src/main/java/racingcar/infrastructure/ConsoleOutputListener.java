package racingcar.infrastructure;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingEventListener;
import racingcar.ui.RacingCarView;

public class ConsoleOutputListener implements RacingEventListener {

    private final RacingCarView racingCarView;

    public ConsoleOutputListener(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    @Override
    public void onTrialFinished(List<RacingCar> racingCars) {
        racingCarView.printTrialResult(racingCars);
    }
}
