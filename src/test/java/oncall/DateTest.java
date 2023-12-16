package oncall;

import java.util.stream.Stream;
import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DateTest {

    @ParameterizedTest
    @MethodSource("dateProvider")
    void date(int money, int date, DayOfWeek dayOfWeek) {
        Assertions.assertThatThrownBy(() -> new Date(money, date, dayOfWeek))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> dateProvider() {
        return Stream.of(
                Arguments.of(0, 2, DayOfWeek.MONDAY),
                Arguments.of(13, 3, DayOfWeek.TUESDAY),
                Arguments.of(12, 32, DayOfWeek.SUNDAY),
                Arguments.of(2, 29, DayOfWeek.MONDAY),
                Arguments.of(3, 0, DayOfWeek.MONDAY)
        );
    }

    @ParameterizedTest
    @MethodSource("hasNextProvider")
    void hasNext(Date value, boolean expected) {
        Assertions.assertThat(value.hasNextDay()).isEqualTo(expected);
    }

    static Stream<Arguments> hasNextProvider() {
        return Stream.of(
                Arguments.of(new Date(5, 1, DayOfWeek.MONDAY), true),
                Arguments.of(new Date(5, 30, DayOfWeek.MONDAY), true),
                Arguments.of(new Date(5, 31, DayOfWeek.SUNDAY), false),
                Arguments.of(new Date(6, 1, DayOfWeek.MONDAY), true),
                Arguments.of(new Date(6, 30, DayOfWeek.WEDNESDAY), false),
                Arguments.of(new Date(2, 27, DayOfWeek.MONDAY), true),
                Arguments.of(new Date(2, 28, DayOfWeek.MONDAY), false)
        );
    }

    @DisplayName("다음 날짜를 반환한다.")
    @ParameterizedTest
    @MethodSource("getNextDateProvider")
    void getNextDate(Date value, Date expected) {
        Date actual = Date.getNextDay(value);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> getNextDateProvider() {
        return Stream.of(
                Arguments.of(new Date(1, 1, DayOfWeek.MONDAY), new Date(1, 2, DayOfWeek.TUESDAY)),
                Arguments.of(new Date(1, 2, DayOfWeek.MONDAY), new Date(1, 3, DayOfWeek.TUESDAY)),
                Arguments.of(new Date(1, 3, DayOfWeek.MONDAY), new Date(1, 4, DayOfWeek.TUESDAY))
        );
    }
}