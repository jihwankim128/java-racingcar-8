package racingcar.domain;

import java.util.EventListener;
import java.util.List;

public interface RacingEventListener extends EventListener {

    void onTrialFinished(List<RacingCar> racingCars);

    void onRacingStarted();
}
