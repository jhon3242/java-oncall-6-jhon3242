package oncall;

import java.util.Arrays;
import java.util.List;
import oncall.message.ExceptionMessage;

public class Converter {
    public static Workers stringToWorkers(String workers) {
        List<Worker> list = Arrays.stream(workers.split(","))
                .map(name -> new Worker(name.trim()))
                .toList();
        return new Workers(list);
    }

    public static Date stringToDate(String value) {
        final int START_DATE = 1;
        List<String> result = Arrays.stream(value.split(",")).toList();
        if (result.size() != 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        validateNumber(result.get(0));
        return new Date(Integer.parseInt(result.get(0)), START_DATE, DayOfWeek.findByString(result.get(1)));
    }

    private static void validateNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }
}
