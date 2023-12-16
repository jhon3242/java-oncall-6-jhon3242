package oncall;

public class MainController {
    public void run() {
        Date date = new Date(5, "월");
        Workers weekdayWorkers = Converter.stringToWorkers("준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리");
        Workers weekendWorkers = Converter.stringToWorkers("수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니");

        Distributor distributor = new Distributor(weekdayWorkers, weekendWorkers);

        do {
            distributor.getWorker(date);
        } while (date.isNotEnd());

    }



}
