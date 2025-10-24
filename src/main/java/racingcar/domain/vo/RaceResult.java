package racingcar.domain.vo;

import racingcar.domain.Car;

public record RaceResult(String carName, int position) {

    public static RaceResult from(Car car) {
        return new RaceResult(car.getName(), car.getPosition());
    }
}
