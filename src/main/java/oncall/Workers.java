package oncall;

import java.util.ArrayList;
import java.util.List;
import oncall.message.ExceptionMessage;

public class Workers {
    public static final int MIN_WORKER_SIZE = 5;
    public static final int MAX_WORKER_SIZE = 35;


    private final List<Worker> workers;
    private long sequence = 0L;

    public Workers(List<Worker> workers) {
        validate(workers);
        this.workers = new ArrayList<>(workers);
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
        return workers.get((int) (sequence++ % workers.size()));
    }
}
