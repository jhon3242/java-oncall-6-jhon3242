package oncall;

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
        addToListAgain(result);
        return result;
    }

    private void addToListAgain(Worker target) {
        if (isAlreadyOnList(target)) {
            // 순서 교체로 이전에 이미 리스트에 올라가 있는 경우
            return;
        }
        workers.addLast(target);
    }

    private boolean isAlreadyOnList(Worker target) {
        return workers.stream()
                .anyMatch(worker -> worker.equals(target));
    }

    public Worker switchWorker(Worker sameWorker) {
        Worker nextWorker = getWorker();
        workers.addFirst(sameWorker);
        return nextWorker;
    }
}
