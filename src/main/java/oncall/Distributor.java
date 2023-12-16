package oncall;

public class Distributor {
    private Workers weekdayWorkers;
    private Workers weekendWorkers;

    public Distributor(Workers weekdayWorkers, Workers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public String getWorker(Date date) {
        if (date.isDayOff()) {
            return weekendWorkers.getWorker();
        }
        return weekdayWorkers.getWorker();
    }
}
