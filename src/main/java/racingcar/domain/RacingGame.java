package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars = new ArrayList<>();
    private int trialCount;

    public RacingGame(String carNames, int trialCount) {
        String[] tokens = carNames.split(",");
        for (String token : tokens) {
            racingCars.add(new RacingCar(token));
        }
        this.trialCount = trialCount;
    }

    public boolean canStart() {
        return trialCount > 0;
    }

    public List<RacingCar> start() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
        trialCount--;
        return new ArrayList<>(racingCars);
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
