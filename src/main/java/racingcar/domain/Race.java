package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.vo.RaceResult;

public class Race {

    private final List<Car> cars = new ArrayList<>();

    public Race(List<String> carNames) {
        validateNotEmpty(carNames);
        carNames.forEach(carName -> {
            Car car = new Car(carName);
            cars.add(car);
        });
    }

    private static void validateNotEmpty(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("레이싱 참여자는 필수 정보입니다.");
        }
    }

    public void play(ForwardCondition forwardCondition) {
        cars.forEach(car -> car.tryMoveForward(forwardCondition));
    }

    public List<RaceResult> getRaceResult() {
        return cars.stream()
                .map(RaceResult::from)
                .toList();
    }

    public List<String> getWinners() {
        int maxForwardCount = getMaxForwardCount();
        return cars.stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .toList();
    }

    private int getMaxForwardCount() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }
}
