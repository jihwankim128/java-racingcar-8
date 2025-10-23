package racingcar.domain;

public class Trial {

    private int count;

    public Trial(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
        this.count = count;
    }

    public void decrement() {
        if (!canTry()) {
            throw new IllegalArgumentException("더 이상 시도할 수 없습니다.");
        }
        count--;
    }

    public boolean canTry() {
        return count > 0;
    }
}
