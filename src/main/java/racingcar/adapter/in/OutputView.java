package racingcar.adapter.in;

import java.util.List;
import racingcar.domain.vo.RaceResult;

public class OutputView {

    private static final String FORWARD_MARKER = "-";
    private static final String RACE_RESULT_FORMAT = "%s : %s%n";

    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printAttemptResult(List<RaceResult> raceResults) {
        for (RaceResult raceResult : raceResults) {
            String forward = FORWARD_MARKER.repeat(raceResult.forwardCount());
            System.out.printf(RACE_RESULT_FORMAT, raceResult.carName(), forward);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }
}
