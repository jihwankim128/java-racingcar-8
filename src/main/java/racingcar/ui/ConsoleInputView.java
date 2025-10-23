package racingcar.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public List<String> readInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        return List.of(carNames);
    }

    @Override
    public int readInputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCount = readLine();
        return Integer.parseInt(trialCount);
    }
}
