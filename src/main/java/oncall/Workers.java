package oncall;

import java.util.ArrayList;
import java.util.List;
import oncall.message.ExceptionMessage;

public class Workers {
    public static final int MIN_WORKER_SIZE = 5;
    public static final int MAX_WORKER_SIZE = 35;
    public static final int MIN_WORKER_NAME_LENGTH = 5;

    private final List<String> workers;
    private long sequence = 0L;

    public Workers(List<String> workers) {
        validate(workers);
        this.workers = new ArrayList<>(workers);
    }

    private void validate(List<String> workers) {
        validateSize(workers);
        validateName(workers);
        validateDistinct(workers);
    }

    private void validateSize(List<String> workers) {
        if (workers.size() < MIN_WORKER_SIZE || workers.size() > MAX_WORKER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    private void validateName(List<String> workers) {
        workers.forEach(worker -> {
            if (worker.length() > MIN_WORKER_NAME_LENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
            }
        });
    }

    private void validateDistinct(List<String> workers) {
        int onlyWorkerCount = (int) workers.stream()
                .distinct()
                .count();
        if (onlyWorkerCount != workers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public String getWorker() {
        return workers.get((int) (sequence++ % workers.size()));
    }
}
