package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars = new ArrayList<>();
    private final RacingEventListener eventListener;
    private int trialCount;

    public RacingGame(String carNames, int trialCount, RacingEventListener eventListener) {
        String[] tokens = carNames.split(",");
        for (String token : tokens) {
            racingCars.add(new RacingCar(token));
        }
        this.trialCount = trialCount;
        this.eventListener = eventListener;
    }

    public boolean hasMoreTrials() {
        return trialCount > 0;
    }

    public void play() {
        eventListener.onRacingStarted();
        while (hasMoreTrials()) {
            racingCars.forEach(RacingCar::move);
            trialCount--;
            eventListener.onTrialFinished(racingCars);
        }
        List<String> winners = getWinners();
        eventListener.onRacingFinished(winners);
    }

    public List<String> getWinners() {
        List<RacingCar> racingResult = new ArrayList<>(racingCars);
        int maxForwardCount = getWinnerForwardCount(racingResult);
        return racingResult.stream()
                .filter(racingCar -> racingCar.getForwardCount() == maxForwardCount)
                .map(RacingCar::getCarName)
                .toList();
    }

    private int getWinnerForwardCount(List<RacingCar> racingResult) {
        int maxForwardCount = 0;
        for (RacingCar racingCar : racingResult) {
            maxForwardCount = Math.max(maxForwardCount, racingCar.getForwardCount());
        }
        return maxForwardCount;
    }
}
