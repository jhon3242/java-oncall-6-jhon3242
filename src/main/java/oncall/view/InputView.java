package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.message.ExceptionMessage;

public class InputView {

    public static String readString(String message) {
        System.out.println(message);
        String value = Console.readLine().trim();
        validateBlank(value);
        return value;
    }

    private static void validateBlank(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

}
