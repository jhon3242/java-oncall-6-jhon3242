package oncall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WorkersTest {

    @Test
    void init() {
    }

    @Test
    void invalidInit() {
        Assertions.assertThatThrownBy(() -> Converter.stringToWorkers("준밥,도밥,준밥,수아,루루,글로"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}