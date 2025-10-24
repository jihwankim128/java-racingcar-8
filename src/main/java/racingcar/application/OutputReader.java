package racingcar.application;

import java.util.List;

public interface OutputReader {
    void printRacingStarted();

    void printTrialResult(List<PlayResult> result);

    void printWinners(List<String> winners);
}
