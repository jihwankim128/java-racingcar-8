package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.vo.PlayResult;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> carNames) {
        for (String carName : carNames) {
            Player player = new Player(carName);
            players.add(player);
        }
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public List<Player> play(MoveCondition moveCondition) {
        players.stream()
                .filter(player -> moveCondition.canMove())
                .forEach(Player::moveForward);
        return getPlayers();
    }

    public void race(MoveCondition moveCondition) {
        players.stream()
                .filter(player -> moveCondition.canMove())
                .forEach(Player::moveForward);
    }

    public List<PlayResult> getRaceResult() {
        return players.stream()
                .map(PlayResult::from)
                .toList();
    }

    public List<String> getWinners() {
        int maxForwardCount = getMaxForwardCount();
        return players.stream()
                .filter(player -> player.getForwardCount() == maxForwardCount)
                .map(Player::getCarName)
                .toList();
    }

    private int getMaxForwardCount() {
        return players.stream()
                .mapToInt(Player::getForwardCount)
                .max()
                .orElse(0);
    }
}
