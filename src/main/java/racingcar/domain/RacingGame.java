package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final RacingEventListener eventListener;
    private final Players players = new Players();
    private final TrialCount trialCount;

    public RacingGame(List<String> carNames, int trialCount, RacingEventListener eventListener) {
        for (String carName : carNames) {
            Player player = new Player(carName);
            players.add(player);
        }
        this.trialCount = new TrialCount(trialCount);
        this.eventListener = eventListener;
    }

    public void play() {
        eventListener.onRacingStarted();
        while (trialCount.canTry()) {
            trialCount.decrement();
            List<Player> playResult = players.play();
            eventListener.onTrialFinished(playResult);
        }

        List<String> winners = players.getWinners();
        eventListener.onRacingFinished(winners);
    }
}
