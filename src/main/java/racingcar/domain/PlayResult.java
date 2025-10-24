package racingcar.domain;

public record PlayResult(String carName, int forwardCount) {

    public static PlayResult from(Player player) {
        return new PlayResult(player.getCarName(), player.getForwardCount());
    }
}
