package oncall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import oncall.message.ExceptionMessage;

public class Workers {
    public static final int MIN_WORKER_SIZE = 5;
    public static final int MAX_WORKER_SIZE = 35;

    private final LinkedList<Worker> workers;

    public Workers(List<Worker> workers) {
        validate(workers);
        this.workers = new LinkedList<>(workers);
    }

    private void validate(List<Worker> workers) {
        validateSize(workers);
        validateDistinct(workers);
    }

    private void validateSize(List<Worker> workers) {
        if (workers.size() < MIN_WORKER_SIZE || workers.size() > MAX_WORKER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    private void validateDistinct(List<Worker> workers) {
        int onlyWorkerCount = (int) workers.stream()
                .map(Worker::getName)
                .distinct()
                .count();
        if (onlyWorkerCount != workers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public Worker getWorker() {
        Worker result = workers.removeFirst();
        handleSameWorkerOnList(result);
        workers.addLast(result);
        return result;
    }

    // 이미 제거했는데 리스트에 있는 경우(switchWorker 에서 잘못 추가된 경우)
    private void handleSameWorkerOnList(Worker target) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).equals(target)) {
                workers.remove(i);
                return;
            }
        }
    }

    public Worker switchWorker(Worker sameWorker) {
        Worker nextWorker = getWorker();
        workers.addFirst(sameWorker);
        return nextWorker;
    }
}
