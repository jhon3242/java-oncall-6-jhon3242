package oncall.view;

import java.util.List;
import oncall.Date;
import oncall.message.ViewMessage;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printException(IllegalArgumentException exception) {
        System.out.println(ViewMessage.ERROR_PREFIX + exception.getMessage());
    }

    public static void printWorker(Date date, String worker) {
        System.out.printf("%d월 %d일 %s %s\n", date.getMonth(), date.getDay(), date.getDayOfWeek(), worker);
    }

    public static void printWorkers(Date startDate, List<String> strings) {
        Date date = startDate;
        for (String worker : strings) {
            printWorker(date, worker);
            date = Date.getNextDay(date);
        }
    }
}
