package racingcar.domain.vo;

import racingcar.domain.Car;

public record PlayResult(String carName, int forwardCount) {

    public static PlayResult from(Car car) {
        return new PlayResult(car.getName(), car.getPosition());
    }
}
