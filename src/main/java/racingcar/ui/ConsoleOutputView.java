package racingcar.ui;

import java.util.List;
import racingcar.domain.Player;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRacingStarted() {
        System.out.println("\n실행 결과");
    }

    public void printTrialResult(List<Player> result) {
        for (Player player : result) {
            System.out.println(player.getCarName() + " : " + "-".repeat(player.getForwardCount()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }
}
