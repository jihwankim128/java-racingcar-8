package racingcar.adapter.external;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.ForwardCondition;

public class RandomForwardCondition implements ForwardCondition {

    private static final int THRESHOLD = 4;

    @Override
    public boolean canMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= THRESHOLD;
    }
}
