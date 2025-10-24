package racingcar.ui;

import java.util.List;
import racingcar.domain.PlayResult;

public interface OutputView {
    void printRacingStarted();

    void printTrialResult(List<PlayResult> result);

    void printWinners(List<String> winners);
}
