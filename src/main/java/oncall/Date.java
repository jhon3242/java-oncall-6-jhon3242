package oncall;

import oncall.message.ExceptionMessage;

public class Date {
    private int month;
    private int day;
    private String dayOfWeek;

    public Date(int month, int startDay, String startDate) {
        validateMonth(month);
        validateStartDay(startDay);
        validateStartDate(startDate);
        this.month = month;
        this.day = startDay;
        this.dayOfWeek = startDate;
    }

    private void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    private void validateStartDay(int startDay) {
        if (startDay < 1 || startDay > 31) {
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
        return dayOfWeek.equals("토") || dayOfWeek.equals("일");
    }

    public static Date getNextDay(Date date) {
        if (date.hasNextDay()) {
            String nextDayOfWeek = date.getNextDayOfWeek();
            int nextDay = date.getDay() + 1;
            Date next = new Date(date.month, nextDay, nextDayOfWeek);
            return next;
        }
        return null;
    }

    // TODO 리팩터링
//    public void nextDay() {
//        day++;
//        String nextDayOfWeek = getNextDayOfWeek();
//        dayOfWeek = nextDayOfWeek;
//    }

    private String getNextDayOfWeek() {
        if (dayOfWeek.equals("월")) {
            return "화";
        }
        if (dayOfWeek.equals("화")) {
            return "수";
        }
        if (dayOfWeek.equals("수")) {
            return "목";
        }
        if (dayOfWeek.equals("목")) {
            return "금";
        }
        if (dayOfWeek.equals("금")) {
            return "토";
        }
        if (dayOfWeek.equals("토")) {
            return "일";
        }
        if (dayOfWeek.equals("일")) {
            return "월";
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
    }

    public boolean hasNextDay() {
        if (month <= 7) {
            if (month % 2 == 1) {
                return day < 31;
            }
            if (month == 2) {
                return day < 28;
            }
            return day < 30;
        }
        if (month % 2 == 0) {
            return day < 31;
        }
        return day < 30;
    }

//    public boolean isNotEnd() {
//        if (month <= 7) {
//            if (month % 2 == 1) {
//                return day <= 31;
//            }
//            if (month == 2) {
//                return day <= 28;
//            }
//            return day <= 30;
//        }
//        if (month % 2 == 0) {
//            return day <= 31;
//        }
//        return day <= 30;
//    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        if (isHoliday()) {
            return dayOfWeek +"(휴일)";
        }
        return dayOfWeek;
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", startDate='" + dayOfWeek + '\'' +
                '}';
    }
}
