package oncall;

import java.util.List;
import oncall.message.ExceptionMessage;

public class Workers {
    private static int sequence = 0;
    private List<String> workers;

    public Workers(List<String> workers) {
        validate(workers);
        this.workers = workers;
    }

    private void validate(List<String> workers) {
        validateEmpty(workers);
        validateDistinct(workers);
    }

    private void validateEmpty(List<String> workers) {
        if (workers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
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
        return workers.get(sequence++ % workers.size());
    }
}
