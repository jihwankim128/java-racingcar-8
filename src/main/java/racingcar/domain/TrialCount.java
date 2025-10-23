package racingcar.domain;

public class TrialCount {

    private int trialCount;

    public TrialCount(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
        this.trialCount = trialCount;
    }

    public void decrement() {
        if (!canTry()) {
            throw new IllegalArgumentException("더 이상 시도할 수 없습니다.");
        }
        trialCount--;
    }

    public boolean canTry() {
        return trialCount > 0;
    }
}
