package oncall;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DistributorTest {

    @Test
    void init() {
        Workers weekday = Converter.stringToWorkers("준팍,도밥,고니,수아,루루,글로");
        Workers weekend = Converter.stringToWorkers("수아,루루,글로,솔로스타,우코");

        Distributor distributor = new Distributor(weekday, weekend);
        Date date = new Date(5, "월");

        Assertions.assertThat(distributor.getWorker(date)).isEqualTo("준팍");
        date.nextDay();
        Assertions.assertThat(distributor.getWorker(date)).isEqualTo("도밥");
        date.nextDay();
        Assertions.assertThat(distributor.getWorker(date)).isEqualTo("고니");
        date.nextDay();
        Assertions.assertThat(distributor.getWorker(date)).isEqualTo("수아");
    }

    @Test
    void doubleWorkWithWeekend() {
        Workers weekday = Converter.stringToWorkers("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        Workers weekend = Converter.stringToWorkers("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");

        Distributor distributor = new Distributor(weekday, weekend);
        Date date = new Date(5, "월");

//        Assertions.assertThat(distributor.getNextWorker(null, date)).isEqualTo("준팍");
//        date.nextDay();
//        Assertions.assertThat(distributor.getNextWorker("준팍", date)).isEqualTo("도밥");
//        date.nextDay();
//        Assertions.assertThat(distributor.getNextWorker("도밥", date)).isEqualTo("고니");
//        date.nextDay();
//        Assertions.assertThat(distributor.getNextWorker("고니", date)).isEqualTo("수아");
//        date.nextDay();
//        Assertions.assertThat(distributor.getNextWorker("수이", date)).isEqualTo("루루");
    }
}