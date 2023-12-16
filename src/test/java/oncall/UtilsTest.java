package oncall;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void switchList() {
        List<String> temp = new ArrayList<>(List.of("1", "2", "3", "4", "5"));

        Utils.switchList(temp, 0, 2);
        Assertions.assertThat(temp).isEqualTo(List.of("3", "2", "1", "4", "5"));
    }
}