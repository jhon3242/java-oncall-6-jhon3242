package oncall;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DayOfWeekTest {


    @ParameterizedTest
    @MethodSource("nextDayOfWeekProvider")
    void nextDayOfWeek(DayOfWeek source, DayOfWeek expected) {
        DayOfWeek actual = DayOfWeek.getNext(source);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> nextDayOfWeekProvider() {
        return Stream.of(
                Arguments.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY),
                Arguments.of(DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY),
                Arguments.of(DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY),
                Arguments.of(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY),
                Arguments.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY),
                Arguments.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY),
                Arguments.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
        );
    }
}