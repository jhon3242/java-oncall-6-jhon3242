package oncall;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {

    @DisplayName("근무자 문자열 변환에 대한 예외 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"준팍,도밥,고니", "  ,  준팍,도밥", " "})
    void stringToWorkersFail(String input) {
        Assertions.assertThatThrownBy(() -> Converter.stringToWorkers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("근무자 문자열 변환에 대한 성공 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"준팍,도밥,고니,룰루,솔로스타", "수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니"})
    void stringToWorkersSuccess(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> Converter.stringToWorkers(input));
    }

    @DisplayName("날짜 문자열 변환에 대한 예외 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"0,월", "12,무", "13,월", "월,1"})
    void stringToDateFail(String input) {
        Assertions.assertThatThrownBy(() -> Converter.stringToDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 문자열 변환에 대한 성공 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"1,월", "12,일", "1,일", "12,월"})
    void stringToDateSuccess(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> Converter.stringToDate(input));
    }

}