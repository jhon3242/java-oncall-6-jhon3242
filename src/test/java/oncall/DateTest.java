package oncall;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DateTest {

    @Test
    void isDayOff() {
        Date date = new Date(5, "월");

        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
        date.nextDay();
        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
        date.nextDay();
    }

}