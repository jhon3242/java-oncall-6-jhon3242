package oncall;

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

    public static DayOfWeek getNext(Date date) {
//        date.nextDay();
        throw new IllegalArgumentException();
    }

    public String getDay() {
        return day;
    }
}
