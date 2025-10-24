package racingcar;

import racingcar.application.InputReader;
import racingcar.application.OutputReader;
import racingcar.application.RacingCarController;
import racingcar.domain.MoveCondition;
import racingcar.domain.RandomMoveCondition;
import racingcar.ui.ConsoleInputReader;
import racingcar.ui.ConsoleOutputReader;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputReader outputReader = new ConsoleOutputReader();
        MoveCondition moveCondition = new RandomMoveCondition();

        RacingCarController racingCarController = new RacingCarController(inputReader, outputReader, moveCondition);
        racingCarController.run();
    }
}
