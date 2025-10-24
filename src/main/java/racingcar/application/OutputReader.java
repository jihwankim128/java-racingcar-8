package racingcar.application;

import java.util.List;
import racingcar.domain.vo.PlayResult;

public interface OutputReader {
    void printRacingStarted();

    void printTrialResult(List<PlayResult> result);

    void printWinners(List<String> winners);
}
