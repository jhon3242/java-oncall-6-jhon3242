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
        Date date = new Date(5,1, "월");

//        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(false);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
//        date.nextDay();
//        Assertions.assertThat(date.isDayOff()).isEqualTo(true);
//        date.nextDay();
    }

//    @Test
//    void isNotEnd1() {
//        Date date = new Date(7, "월");
//        for (int i = 0; i < 31; i++) {
//            Assertions.assertThat(date.isNotEnd()).isEqualTo(true);
//            date.nextDay();
//        }
//        Assertions.assertThat(date.isNotEnd()).isEqualTo(false);
//    }
//
//    @Test
//    void isNotEnd2() {
//        Date date = new Date(8, "월");
//        for (int i = 0; i < 31; i++) {
//            Assertions.assertThat(date.isNotEnd()).isEqualTo(true);
//            date.nextDay();
//        }
//        Assertions.assertThat(date.isNotEnd()).isEqualTo(false);
//    }
//
//    @Test
//    void isNotEnd3() {
//        Date date = new Date(9, "월");
//        for (int i = 0; i < 30; i++) {
//            Assertions.assertThat(date.isNotEnd()).isEqualTo(true);
//            date.nextDay();
//        }
//        Assertions.assertThat(date.isNotEnd()).isEqualTo(false);
//    }
}