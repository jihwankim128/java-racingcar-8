package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Players players = new Players();
    private final RacingEventListener eventListener;
    private int trialCount;

    public RacingGame(List<String> carNames, int trialCount, RacingEventListener eventListener) {
        for (String carName : carNames) {
            Player player = new Player(carName);
            players.add(player);
        }
        this.trialCount = trialCount;
        this.eventListener = eventListener;
    }

    public boolean hasMoreTrials() {
        return trialCount > 0;
    }

    public void play() {
        eventListener.onRacingStarted();
        while (hasMoreTrials()) {
            trialCount--;
            List<Player> playResult = players.play();
            eventListener.onTrialFinished(playResult);
        }

        int maxForwardCount = players.getMaxForwardCount();
        List<String> winners = players.getWinners(maxForwardCount);
        eventListener.onRacingFinished(winners);
    }
}
