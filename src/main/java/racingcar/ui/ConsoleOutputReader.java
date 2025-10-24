package racingcar.ui;

import java.util.List;
import racingcar.application.OutputReader;
import racingcar.application.PlayResult;

public class ConsoleOutputReader implements OutputReader {
    @Override
    public void printRacingStarted() {
        System.out.println("\n실행 결과");
    }

    public void printTrialResult(List<PlayResult> result) {
        for (PlayResult player : result) {
            System.out.println(player.carName() + " : " + "-".repeat(player.forwardCount()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }
}
