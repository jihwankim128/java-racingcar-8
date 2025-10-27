package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.vo.RaceResult;

public class RacingGame {

    private static final int MIN_RACING_PARTICIPANT = 1;

    private final List<Car> cars = new ArrayList<>();

    public RacingGame(List<String> carNames) {
        validateRacingParticipant(carNames);
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    private static void validateRacingParticipant(List<String> carNames) {
        if (carNames == null || carNames.size() < MIN_RACING_PARTICIPANT) {
            throw new IllegalArgumentException("레이싱 참여자는 최소 %s명 이상이어야합니다.".formatted(MIN_RACING_PARTICIPANT));
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
