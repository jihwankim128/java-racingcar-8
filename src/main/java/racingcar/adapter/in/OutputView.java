package racingcar.adapter.in;

import java.util.List;
import racingcar.domain.vo.RaceResult;

public class OutputView {

    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printAttemptResult(List<RaceResult> raceResults) {
        for (RaceResult raceResult : raceResults) {
            System.out.println(raceResult.carName() + " : " + "-".repeat(raceResult.forwardCount()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }
}
