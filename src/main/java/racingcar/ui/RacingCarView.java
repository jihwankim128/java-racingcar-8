package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarView {

    public void printInputCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String readInputCarNames() {
        return Console.readLine();
    }

    public void printInputTryCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public int readInputTryCount() {
        return Integer.parseInt(Console.readLine());
    }

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
