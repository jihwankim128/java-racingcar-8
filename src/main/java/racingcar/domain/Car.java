package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
