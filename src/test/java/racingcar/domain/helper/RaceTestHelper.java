package racingcar.domain.helper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import racingcar.domain.MoveCondition;
import racingcar.domain.Race;

public class RaceTestHelper {

    public static Stream<Arguments> moveConditions() {
        return Stream.of(
                Arguments.of((MoveCondition) () -> false, List.of(0, 0, 0)),    // 모두 이동하지 않음
                Arguments.of((MoveCondition) () -> true, List.of(1, 1, 1)),     // 모두 이동
                Arguments.of(evenMoveCondition(), List.of(1, 0, 1))             // 짝수번째만 이동
        );
    }

    public static Stream<Arguments> winnerConditions() {
        // moveConditions 결과와 이동 결과 동일
        return Stream.of(
                Arguments.of((MoveCondition) () -> false, List.of("이프", "포비", "우테코")),
                Arguments.of((MoveCondition) () -> true, List.of("이프", "포비", "우테코")),
                Arguments.of(evenMoveCondition(), List.of("이프", "우테코"))
        );
    }

    private static MoveCondition evenMoveCondition() {
        AtomicInteger counter = new AtomicInteger(0);
        return () -> counter.getAndIncrement() % 2 == 0;
    }

    public static Race createRace() {
        List<String> carNames = List.of("이프", "포비", "우테코");
        return new Race(carNames);
    }
}
