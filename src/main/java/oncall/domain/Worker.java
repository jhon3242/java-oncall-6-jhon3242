package oncall.domain;

import oncall.message.ExceptionMessage;

public class Worker {
    public static final int MIN_WORKER_NAME_LENGTH = 5;

    private final String name;

    public Worker(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (name.length() > MIN_WORKER_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public String getName() {
        return name;
    }
}
