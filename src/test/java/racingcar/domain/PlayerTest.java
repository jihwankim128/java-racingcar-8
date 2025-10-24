package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = " ")
    @NullAndEmptySource
    void 잘못된_자동차_이름으로_선수_등록은_할_수_없다(String invalidCarName) {
        // when & then
        assertThatThrownBy(() -> new Player(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자를_초과해도_선수로_등록할_수_없다() {
        // given
        String invalidCarName = "1".repeat(6);

        // when & then
        assertThatThrownBy(() -> new Player(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_자동차_이름으로_선수_등록시_이동_거리는_0이다() {
        // given
        String carName = "1".repeat(5);

        // when
        Player player = new Player(carName);

        // then
        assertThat(player.getForwardCount()).isEqualTo(0);
    }

    @Test
    void 선수가_주어질_때_전진하면_전진_횟수가_증가한다() {
        // given
        Player player = new Player("이프");
        int before = player.getForwardCount();

        // when
        player.moveForward();

        // then
        assertThat(player.getForwardCount()).isEqualTo(before + 1);
    }
}