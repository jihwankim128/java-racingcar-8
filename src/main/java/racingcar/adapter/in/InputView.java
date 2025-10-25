package racingcar.adapter.in;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {

    public List<String> readInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        return List.of(carNames);
    }

    public int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCount = readLine();
        return Integer.parseInt(trialCount);
    }
}
