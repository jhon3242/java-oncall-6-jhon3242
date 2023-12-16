package oncall;

import oncall.message.ViewMessage;
import oncall.view.InputView;
import oncall.view.OutputView;

public class MainController {
    public void run() {
        Date date = initDate();
        System.out.println(date);

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

}
