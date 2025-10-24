package racingcar.ui;

import java.util.List;
import racingcar.application.PlayResult;

public interface OutputView {
    void printRacingStarted();

    void printTrialResult(List<PlayResult> result);

    void printWinners(List<String> winners);
}
