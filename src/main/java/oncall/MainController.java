package oncall;

import java.util.List;
import oncall.message.ViewMessage;
import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {
    public void run() {
        Date date = initDate();
        Distributor distributor = initDistributor();
        List<String> workers = distributor.calculateWorkerList(date);
        OutputView.printWorkers(date, workers);
    }

    private static Date initDate() {
        try {
            String value = InputView.readString(ViewMessage.INPUT_START_DATE);
            return Converter.stringToDate(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initDate();
        }
    }

    private static Distributor initDistributor() {
        try {
            Workers weekdayWorkers = initWorkers(ViewMessage.INPUT_WEEKDAY_WORKERS);
            Workers weekendValue = initWorkers(ViewMessage.INPUT_WEEKEND_WORKERS);
            return new Distributor(weekdayWorkers, weekendValue);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initDistributor();
        }
    }

    private static Workers initWorkers(String message) {
        String weekdayValue = InputView.readString(message);
        return Converter.stringToWorkers(weekdayValue);
    }
}
