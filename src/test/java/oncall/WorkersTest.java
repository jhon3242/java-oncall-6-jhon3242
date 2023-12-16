package oncall;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class WorkersTest {

    @Test
    void init() {
        List<String> collect = Arrays.stream("준팍,도밥,고니,수아,루루,글로".split(","))
                .collect(Collectors.toList());
        Workers workers = new Workers(collect);
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
        System.out.println(workers.getWorker());
    }
}