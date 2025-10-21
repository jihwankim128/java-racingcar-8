package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

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

    public void printRacingStart() {
        System.out.println("\n실행 결과");
    }

    public void printResultByRound(String carName, int forwardCount) {
        System.out.println(carName + " : " + "-".repeat(forwardCount));
        System.out.println();
    }

    public void printFinalResult(String finalResult) {
        System.out.println("\n최종 우승자 : " + finalResult);
    }
}
