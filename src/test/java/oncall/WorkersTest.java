package oncall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkersTest {

    @DisplayName("근무자가 5명 미만인 경우 예외를 발생시킨다.")
    @Test
    void init() {
        Assertions.assertThatThrownBy(() -> {
            List<Worker> list = Arrays.stream("준팍,도밥,고니,수아".split(","))
                    .map(name -> new Worker(name.trim()))
                    .collect(Collectors.toList());
            new Workers(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getWorkers 로 모든 근무자를 가져왔으면 다시 처음부터 가져온다.")
    @Test
    void getWorkers() {
        Workers workers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루");

        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("준팍");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("도밥");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("고니");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("수아");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("루루");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("준팍");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("도밥");
    }

    @DisplayName("근무자 교체시 다시 근무자를 가져오면 이전에 가져온 근무자를 가져온다.")
    @Test
    void switchWorker() {
        Workers workers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루");

        Worker worker = workers.getWorker();
        Worker switchWorker = workers.switchWorker(worker);
        Worker nextWorker = workers.getWorker();

        Assertions.assertThat(switchWorker.getName()).isEqualTo("도밥");
        Assertions.assertThat(nextWorker).isEqualTo(worker);
    }

    @DisplayName("근무자 교체 이후에 한바퀴를 돌았을 때 초기화했던 순서대로 가져온다.")
    @Test
    void afterSwitchWorker() {
        Workers workers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루");

        Worker worker = workers.getWorker();
        Worker switchWorker = workers.switchWorker(worker);
        workers.getWorker();
        workers.getWorker();
        workers.getWorker();
        workers.getWorker();

        Worker nextWorker = workers.getWorker();
        Assertions.assertThat(nextWorker.getName()).isEqualTo("준팍");
        Assertions.assertThat(workers.getWorker().getName()).isEqualTo("도밥");
    }
}