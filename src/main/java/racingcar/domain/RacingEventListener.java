package racingcar.domain;

import java.util.EventListener;
import java.util.List;

public interface RacingEventListener extends EventListener {

    void onTrialFinished(List<Player> players);

    void onRacingStarted();

    void onRacingFinished(List<String> winners);
}
