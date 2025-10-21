package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String carName;
    private int forwardCount;

    public RacingCar(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
        }
        this.carName = carName;
        this.forwardCount = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            forwardCount++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
