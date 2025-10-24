package racingcar.adapter.in;

import java.util.List;
import racingcar.application.RacingCarUseCase;
import racingcar.application.RacingCommand;
import racingcar.application.RacingResult;
import racingcar.domain.vo.PlayResult;

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
        List<String> carNames = inputView.readInputCarNames();
        int trialCount = inputView.readTrialCount();

        RacingCommand command = new RacingCommand(carNames, trialCount);
        RacingResult racingResult = racingCarUseCase.startRacing(command);

        printRacingResult(racingResult);
    }

    private void printRacingResult(RacingResult racingResult) {
        List<List<PlayResult>> history = racingResult.history();

        outputView.printRacingStarted();
        history.forEach(outputView::printTrialResult);
        outputView.printWinners(racingResult.winners());
    }
}
