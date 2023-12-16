package oncall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import oncall.message.ExceptionMessage;

public class Converter {
    public static Workers stringToWorkers(String workers) {
        List<String> list = Arrays.stream(workers.split(","))
                .collect(Collectors.toList());
        return new Workers(list);
    }

    public static Date stringToDate(String value) {
        List<String> result = Arrays.stream(value.split(",")).toList();
        if (result.size() != 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        validateNumber(result.get(0));
        return new Date(Integer.parseInt(result.get(0)), 1, DayOfWeek.findByString(result.get(1)));
    }

    private static void validateNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }
}
