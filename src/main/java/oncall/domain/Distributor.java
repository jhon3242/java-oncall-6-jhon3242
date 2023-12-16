package oncall.domain;

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
        List<String> workerLog = new ArrayList<>();
        addWorkerToLog(startDate, workerLog);
        return workerLog;
    }

    private void addWorkerToLog(Date date, List<String> workerLog) {
        while (true) {
            Worker worker = getWorker(date);
            if (isRepeatWorker(worker, workerLog)) {
                worker = switchWorker(date, worker);
            }
            workerLog.add(worker.getName());
            if (date.hasNextDay()) {
                date = Date.getNextDay(date);
                continue;
            }
            break;
        }
    }

    private boolean isRepeatWorker(Worker worker, List<String> prevList) {
        String lastAddWorker = getLastAddWorker(prevList);
        return lastAddWorker.equals(worker.getName());
    }

    private String getLastAddWorker(List<String> result) {
        if (result.size() == 0) {
            return "";
        }
        return result.get(result.size() - 1);
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

