package oncall.view;

import oncall.message.ViewMessage;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printException(IllegalArgumentException exception) {
        System.out.println(ViewMessage.ERROR_PREFIX + exception.getMessage());
    }
}
