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
            Worker worker = getWorker(date);
            String workerName = worker.getName();
            String lastAddWorker = getLastAddWorker(result);
            if (lastAddWorker.equals(workerName)) {
                worker = switchWorker(date, worker);
                workerName = worker.getName();
            }

            result.add(workerName);
            if (date.hasNextDay()) {
                date = Date.getNextDay(date);
                continue;
            }
            break;
        }
        return handleWorkerList(result);
    }

    private String getLastAddWorker(List<String> result) {
        if (result.size() == 0) {
            return "";
        }
        return result.get(result.size() - 1);
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

    public Worker getWorker(Date date) {
        if (date.isDayOff()) {
            return weekendWorkers.getWorker();
        }
        return weekdayWorkers.getWorker();
    }

    public Worker switchWorker(Date date, Worker worker) {
        if (date.isDayOff()) {
            return weekendWorkers.switchWorker(worker);
        }
        return weekdayWorkers.switchWorker(worker);
    }
}

