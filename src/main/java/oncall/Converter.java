package oncall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static Workers stringToWorkers(String workers) {
        List<String> list = Arrays.stream(workers.split(","))
                .collect(Collectors.toList());
        return new Workers(list);
    }
}
