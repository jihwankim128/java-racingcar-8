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
        int trialCount = inputView.readTrialCount();
        return new RacingCommand(carNames, trialCount);
    }

    private void printRacingResult(RacingResult racingResult) {
        List<List<RaceResult>> history = racingResult.history();

        outputView.printRacingStarted();
        history.forEach(outputView::printTrialResult);
        outputView.printWinners(racingResult.winners());
    }
}
