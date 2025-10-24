package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.helper.RaceTestHelper.createRace;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.vo.RaceResult;

class RaceTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 경주_참여자_등록_시_참여자_정보가_필수이다(List<String> emptyCarNames) {
        // when & then
        assertThatThrownBy(() -> new Race(emptyCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("racingcar.domain.helper.RaceTestHelper#moveConditions")
    void 이동_전략에_따라_차량의_위치가_예상대로_결정된다(MoveCondition condition, List<Integer> expected) {
        // given
        Race race = createRace();

        // when
        race.play(condition);

        // then
        assertThat(race.getRaceResult())
                .extracting(RaceResult::position)
                .containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("racingcar.domain.helper.RaceTestHelper#winnerConditions")
    void 경주_우승자를_가져올_수_있다(MoveCondition condition, List<String> expected) {
        // given
        Race race = createRace();
        race.play(condition);

        // when
        List<String> result = race.getWinners();

        // then
        assertThat(result).containsExactlyElementsOf(expected);
    }
}