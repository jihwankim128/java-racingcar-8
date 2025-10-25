package racingcar.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Attempts {

    private static final int MIN_COUNT = 1;
    private final int count;

    public Attempts(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            final String errorMessageFormat = "시도 횟수는 %d보다 작을 수 없습니다.".formatted(MIN_COUNT);
            throw new IllegalArgumentException(errorMessageFormat);
        }
    }

    public <T> List<T> repeat(Supplier<T> action) {
        return IntStream.range(0, count)
                .mapToObj(i -> action.get())
                .toList();
    }
}
