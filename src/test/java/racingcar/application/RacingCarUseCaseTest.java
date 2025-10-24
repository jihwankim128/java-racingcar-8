package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarUseCaseTest {

    @Test
    void 경주_정보로_경주를_시작하면_경주_결과가_반환된다() {
        // given
        List<String> carNames = List.of("이프", "포비", "우테코");
        int trialCount = 3;
        RacingCommand command = new RacingCommand(carNames, trialCount);
        RacingCarUseCase useCase = new RacingCarUseCase(() -> true);

        // when
        RacingResult result = useCase.startRacing(command);

        // then
        assertThat(result.history()).hasSize(trialCount);
        assertThat(result.winners()).containsExactlyElementsOf(carNames);
    }
}