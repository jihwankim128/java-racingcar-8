package racingcar.ui;

import java.util.List;
import racingcar.domain.RacingCar;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRacingStarted() {
        System.out.println("\n실행 결과");
    }

    public void printTrialResult(List<RacingCar> result) {
        for (RacingCar racingCar : result) {
            System.out.println(racingCar.getCarName() + " : " + "-".repeat(racingCar.getForwardCount()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }
}
