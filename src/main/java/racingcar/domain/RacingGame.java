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
}
