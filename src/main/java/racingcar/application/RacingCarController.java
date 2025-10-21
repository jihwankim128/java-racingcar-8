package racingcar.application;

import racingcar.ui.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void run() {
        racingCarView.printInputCarNamesPrompt();
        String carNames = racingCarView.readInputCarNames();
        // TODO: 자동차 정보 생성
        racingCarView.printInputTryCountPrompt();
        int tryCount = racingCarView.readInputTryCount();
        // TODO: 레이싱 시작
        racingCarView.printRacingStart();
        // TODO: 라운드 별 경주 실행
        racingCarView.printResultByRound("carName", 10);
        // TODO: 라운드 끝나고 최종 우승자 계산
        racingCarView.printFinalResult("carName");
    }
}
