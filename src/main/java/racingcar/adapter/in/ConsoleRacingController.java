package racingcar.adapter.in;

import java.util.List;
import racingcar.application.RacingCarUseCase;
import racingcar.application.RacingCommand;
import racingcar.application.RacingResult;
import racingcar.domain.vo.RaceResult;

public class ConsoleRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarUseCase racingCarUseCase;

    public ConsoleRacingController(InputView inputView, OutputView outputView, RacingCarUseCase racingCarUseCase) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarUseCase = racingCarUseCase;
    }

    public void run() {
        RacingCommand command = createCommand();
        RacingResult racingResult = racingCarUseCase.startRacing(command);
        printRacingResult(racingResult);
    }

    private RacingCommand createCommand() {
        List<String> carNames = inputView.readInputCarNames();
        int attemptCount = inputView.readAttemptCount();
        return new RacingCommand(carNames, attemptCount);
    }

    private void printRacingResult(RacingResult racingResult) {
        List<List<RaceResult>> history = racingResult.history();

        outputView.printResultHeader();
        history.forEach(outputView::printAttemptResult);
        outputView.printWinners(racingResult.winners());
    }
}
