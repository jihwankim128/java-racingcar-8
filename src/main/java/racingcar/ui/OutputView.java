package racingcar.ui;

import java.util.List;
import racingcar.domain.Player;

public interface OutputView {
    void printRacingStarted();

    void printTrialResult(List<Player> result);

    void printWinners(List<String> winners);
}
