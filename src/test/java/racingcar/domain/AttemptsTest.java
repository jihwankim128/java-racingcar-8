package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도횟수는_양수만_가능하다(int negativeValue) {
        // when & then
        assertThatThrownBy(() -> new Attempts(negativeValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_주어지면_시도횟수만큼_동작한다() {
        // given
        int trialCount = 3;
        Attempts attempts = new Attempts(trialCount);
        AtomicInteger counter = new AtomicInteger();

        // when
        List<Integer> result = attempts.repeat(counter::incrementAndGet);

        // then
        assertThat(result).contains(1, 2, 3);
    }
}