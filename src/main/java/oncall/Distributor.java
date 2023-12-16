package oncall;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    private final Workers weekdayWorkers;
    private final Workers weekendWorkers;

    public Distributor(Workers weekdayWorkers, Workers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public List<String> calculateWorkerList(Date startDate) {
        Date date = startDate;
        List<String> result = new ArrayList<>();
        while (true) {
            String worker = getWorker(date);
            result.add(worker);
            if (date.hasNextDay()) {
                date = Date.getNextDay(date);
                continue;
            }
            break;
        }
        return handleWorkerList(result);
    }

    private List<String> handleWorkerList(List<String> list) {
        List<String> result = new ArrayList<>(list);
        for (int i = 0; i < result.size() - 1; i++) {
            String worker = result.get(i);
            String nextWorker = result.get(i + 1);
            if (worker.equals(nextWorker) && i + 2 < result.size()) {
                Utils.switchList(result, i + 1, i + 2);
            }
        }
        return result;
    }

    public String getWorker(Date date) {
        if (date.isDayOff()) {
            return weekendWorkers.getWorker();
        }
        return weekdayWorkers.getWorker();
    }
}

