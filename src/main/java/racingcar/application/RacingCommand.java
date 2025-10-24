package racingcar.application;

import java.util.List;

public record RacingCommand(List<String> carNames, int trialCount) {
}
