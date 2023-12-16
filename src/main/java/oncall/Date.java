package oncall;

import oncall.message.ExceptionMessage;

public class Date {
    private int month;
    private int day;
    private DayOfWeek dayOfWeek;

    public Date(int month, int startDay, DayOfWeek startDate) {
        validateMonth(month);
        validateStartDay(startDay);
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

    public boolean isDayOff() {
        return dayOfWeek.isWeekend() || isHoliday();
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

    public static Date getNextDay(Date date) {
        if (date.hasNextDay()) {
            return new Date(date.month, date.day + 1, DayOfWeek.getNext(date.dayOfWeek));
        }
        return null;
    }

    // TODO 리팩터링
//    public void nextDay() {
//        day++;
//        String nextDayOfWeek = getNextDayOfWeek();
//        dayOfWeek = nextDayOfWeek;
//    }

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
            return dayOfWeek.getDay() +"(휴일)";
        }
        return dayOfWeek.getDay();
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
