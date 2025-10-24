package racingcar.domain.vo;

import racingcar.domain.Player;

public record PlayResult(String carName, int forwardCount) {

    public static PlayResult from(Player player) {
        return new PlayResult(player.getCarName(), player.getForwardCount());
    }
}
