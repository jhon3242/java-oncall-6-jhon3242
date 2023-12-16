package oncall;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Converter;
import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import oncall.domain.Distributor;
import oncall.domain.Workers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistributorTest {

    @DisplayName("근무자 리스트에 대한 검증 테스트")
    @Test
    void calculateWorker() {
        Workers weekdayWorkers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루");
        Workers weekendWorkers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루");
        Distributor distributor = new Distributor(weekdayWorkers, weekendWorkers);
        Date date = new Date(5, 1, DayOfWeek.MONDAY);

        List<String> strings = distributor.calculateWorkerList(date);
        List<String> expected = Arrays.stream(
                ("준팍, 도밥, 고니, 수아, 준팍, 도밥, 고니, "
                        + "루루, 준팍, 도밥, 고니, 수아, 루루, 수아, "
                        + "루루, 준팍, 도밥, 고니, 수아, 준팍, 도밥, "
                        + "루루, 준팍, 도밥, 고니, 수아, 고니, 수아, "
                        + "루루, 준팍, 도밥").split(
                        ", ")).toList();
        Assertions.assertThat(strings).isEqualTo(expected);
    }

}