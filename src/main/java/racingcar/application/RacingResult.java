package racingcar.application;

import java.util.List;
import racingcar.domain.vo.RaceResult;

public record RacingResult(List<List<RaceResult>> history, List<String> winners) {
}
