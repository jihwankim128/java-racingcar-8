package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Trial {

    private final int count;

    public Trial(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
        this.count = count;
    }

    public void tryAction(Runnable action) {
        IntStream.range(0, count)
                .forEach(trialCount -> action.run());
    }

    public <T> List<T> tryAction(Supplier<T> action) {
        return IntStream.range(0, count)
                .mapToObj(i -> action.get())
                .toList();
    }
}
