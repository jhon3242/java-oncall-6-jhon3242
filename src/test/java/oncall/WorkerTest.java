package oncall;

import oncall.domain.Worker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WorkerTest {

    @DisplayName("Worker 이름이 올바른 경우 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"name", "포비", "포비포비", "최대5글자"})
    void validWorkerName(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> new Worker(value));

    }

    @DisplayName("Worker 이름이 잘못된 경우 예외를 발생시킨다..")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "5글자를넘는경우"})
    void invalidWorkerName(String value) {
        Assertions.assertThatThrownBy(() -> new Worker(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}