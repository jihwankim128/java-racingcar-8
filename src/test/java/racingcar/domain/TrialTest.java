package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrialTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도횟수는_양수만_가능하다(int negativeValue) {
        // when & then
        assertThatThrownBy(() -> new Trial(negativeValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_주어지면_시도횟수만큼_동작한다() {
        // given
        int trialCount = 3;
        Trial trial = new Trial(trialCount);
        AtomicInteger counter = new AtomicInteger();

        // when
        trial.tryAction(counter::incrementAndGet);

        // then
        assertThat(counter.get()).isEqualTo(trialCount);
    }
}