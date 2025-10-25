package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Trial {

    private static final int MIN_COUNT = 1;
    private final int count;

    public Trial(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            final String errorMessageFormat = "시도 횟수는 %d보다 작을 수 없습니다.".formatted(MIN_COUNT);
            throw new IllegalArgumentException(errorMessageFormat.formatted(MIN_COUNT));
        }
    }

    public <T> List<T> tryAction(Supplier<T> action) {
        return IntStream.range(0, count)
                .mapToObj(i -> action.get())
                .toList();
    }
}
