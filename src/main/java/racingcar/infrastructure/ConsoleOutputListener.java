package racingcar.infrastructure;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingEventListener;
import racingcar.ui.ConsoleOutputView;

public class ConsoleOutputListener implements RacingEventListener {

    private final ConsoleOutputView consoleOutputView;

    public ConsoleOutputListener(ConsoleOutputView consoleOutputView) {
        this.consoleOutputView = consoleOutputView;
    }

    @Override
    public void onTrialFinished(List<RacingCar> racingCars) {
        consoleOutputView.printTrialResult(racingCars);
    }

    @Override
    public void onRacingStarted() {
        consoleOutputView.printRacingStarted();
    }

    @Override
    public void onRacingFinished(List<String> winners) {
        consoleOutputView.printWinners(winners);
    }
}
