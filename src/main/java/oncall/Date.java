package oncall;

import oncall.message.ExceptionMessage;

public class Date {
    private int month;
    private int day;
    private String startDate;

    public Date(int month, String startDate) {
        validateMonth(month);
        validateStartDate(startDate);
        this.month = month;
        this.day = 1;
        this.startDate = startDate;
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    private void validateStartDate(String startDate) {
        if (startDate.length() != 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (!"월화수목금토일".contains(startDate)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

//    private void validateDay(int day) {
//        if (day < 1 || day > 31) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
//        }
//    }
//
//    private void validateFebruary(int month, int day) {
//        if (month == 2 && day > 28) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
//        }
//    }

    public boolean isDayOff() {
        return isWeekend() || isHoliday();
    }

    // TODO 리팩터링
    private boolean isHoliday() {
        if (month == 1 && day == 1) {
            return true;
        }
        if (month == 3 && day == 1) {
            return true;
        }
        if (month == 5 && day == 5) {
            return true;
        }
        if (month == 6 && day == 6) {
            return true;
        }
        if (month == 8 && day == 15) {
            return true;
        }
        if (month == 10 && (day == 3 || day == 9)) {
            return true;
        }
        if (month == 12 && day == 25) {
            return true;
        }
        return false;
    }

    private boolean isWeekend() {
        return startDate.equals("토") || startDate.equals("일");
    }

    // TODO 리팩터링
    public void nextDay() {
        day++;
        if (startDate.equals("월")) {
            startDate = "화";
            return;
        }
        if (startDate.equals("화")) {
            startDate = "수";
            return;
        }
        if (startDate.equals("수")) {
            startDate = "목";
            return;
        }
        if (startDate.equals("목")) {
            startDate = "금";
            return;
        }
        if (startDate.equals("금")) {
            startDate = "토";
            return;
        }
        if (startDate.equals("토")) {
            startDate = "일";
            return;
        }
        if (startDate.equals("일")) {
            startDate = "월";
        }
    }

    public boolean isNotEnd() {
        if (month <= 7) {
            if (month % 2 == 1) {
                return day <= 31;
            }
            if (month == 2) {
                return day <= 28;
            }
            return day <= 30;
        }
        if (month % 2 == 0) {
            return day <= 31;
        }
        return day <= 30;
    }
}
