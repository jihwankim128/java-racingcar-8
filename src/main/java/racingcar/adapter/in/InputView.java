package racingcar.adapter.in;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readTokens();
    }

    public int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readNumber();
    }

    private List<String> readTokens() {
        String[] tokens = readLine().split(",");
        return Arrays.stream(tokens)
                .map(String::trim)
                .toList();
    }

    private int readNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 숫자만 입력해주세요.");
        }
    }
}
