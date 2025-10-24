package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition {

    private static final int THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= THRESHOLD;
    }
}
