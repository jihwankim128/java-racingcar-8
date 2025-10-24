package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> carNames) {
        for (String carName : carNames) {
            Player player = new Player(carName);
            players.add(player);
        }
    }

    public List<Player> play() {
        players.stream()
                .filter(player -> Randoms.pickNumberInRange(0, 9) >= 4)
                .forEach(Player::moveForward);
        return new ArrayList<>(players);
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
