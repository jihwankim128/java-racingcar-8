package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String carNames) {
        String[] tokens = carNames.split(",");
        for (String token : tokens) {
            racingCars.add(new RacingCar(token));
        }
    }

    public List<RacingCar> start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
            }
        }
        return new ArrayList<>(racingCars);
    }
}
