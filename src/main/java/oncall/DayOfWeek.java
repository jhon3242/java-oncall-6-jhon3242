package oncall;

import java.util.Arrays;
import oncall.message.ExceptionMessage;

public enum DayOfWeek {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private String day;

    DayOfWeek(String day) {
        this.day = day;
    }

    public static DayOfWeek findByString(String day) {
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.day.equals(day))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INPUT));
    }

    public static DayOfWeek getNext(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(SUNDAY)) {
            return MONDAY;
        }
        return values()[dayOfWeek.ordinal() + 1];
    }

    public String getDay() {
        return day;
    }

    public boolean isWeekend() {
        return this.equals(SATURDAY) || this.equals(SUNDAY);
    }
}
