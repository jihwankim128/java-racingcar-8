package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Player> players = new ArrayList<>();
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
            players.forEach(Player::move);
            trialCount--;
            eventListener.onTrialFinished(players);
        }
        List<String> winners = getWinners();
        eventListener.onRacingFinished(winners);
    }

    public List<String> getWinners() {
        List<Player> racingResult = new ArrayList<>(players);
        int maxForwardCount = getWinnerForwardCount(racingResult);
        return racingResult.stream()
                .filter(racingCar -> racingCar.getForwardCount() == maxForwardCount)
                .map(Player::getCarName)
                .toList();
    }

    private int getWinnerForwardCount(List<Player> racingResult) {
        int maxForwardCount = 0;
        for (Player player : racingResult) {
            maxForwardCount = Math.max(maxForwardCount, player.getForwardCount());
        }
        return maxForwardCount;
    }
}
