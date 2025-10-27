package racingcar.domain;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private int forwardCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 %s자를 초과할 수 없습니다.".formatted(MAX_CAR_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void tryMoveForward(ForwardCondition condition) {
        if (condition.canMoveForward()) {
            forwardCount++;
        }
    }
}
