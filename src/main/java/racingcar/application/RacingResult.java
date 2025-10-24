package racingcar.application;

import java.util.List;
import racingcar.domain.vo.PlayResult;

public record RacingResult(List<List<PlayResult>> history, List<String> winners) {
}
