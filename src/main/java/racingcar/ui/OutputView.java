package racingcar.ui;

import java.util.List;
import racingcar.domain.RacingCar;

public interface OutputView {
    void printRacingStarted();

    void printTrialResult(List<RacingCar> result);

    void printWinners(List<String> winners);
}
