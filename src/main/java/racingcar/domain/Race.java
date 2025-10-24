package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.vo.PlayResult;

public class Players {

    private final List<Car> cars = new ArrayList<>();

    public Players(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void race(MoveCondition moveCondition) {
        cars.stream()
                .filter(car -> moveCondition.canMove())
                .forEach(Car::moveForward);
    }

    public List<PlayResult> getRaceResult() {
        return cars.stream()
                .map(PlayResult::from)
                .toList();
    }

    public List<String> getWinners() {
        int maxForwardCount = getMaxForwardCount();
        return cars.stream()
                .filter(car -> car.getPosition() == maxForwardCount)
                .map(Car::getName)
                .toList();
    }

    private int getMaxForwardCount() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
