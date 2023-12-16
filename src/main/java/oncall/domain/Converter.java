package oncall.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oncall.message.ExceptionMessage;

public class Converter {
    private static final String namePattern = "^\\d{1,2},[월화수목금토일]";
    public static final Pattern datePattern = Pattern.compile(namePattern);

    public static Workers stringToWorkers(String workers) {
        List<Worker> list = Arrays.stream(workers.split(","))
                .map(name -> new Worker(name.trim()))
                .toList();
        return new Workers(list);
    }

    public static Date stringToDate(String value) {
        final int START_DATE = 1;
        validateDateString(value);
        List<String> result = Arrays.stream(value.split(","))
                .toList();
        return new Date(Integer.parseInt(result.get(0)), START_DATE, DayOfWeek.findByString(result.get(1)));
    }

    private static void validateDateString(String value) {
        Matcher matcher = datePattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }
}
