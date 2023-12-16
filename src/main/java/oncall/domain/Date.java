package oncall.domain;

import java.util.Objects;
import oncall.message.ExceptionMessage;

public class Date {
    private final int month;
    private final int date;
    private final DayOfWeek dayOfWeek;

    public Date(int month, int startDate, DayOfWeek startDayOfWeek) {
        validateMonth(month);
        validateDate(month, startDate);
        validateStartDay(startDate);
        this.month = month;
        this.date = startDate;
        this.dayOfWeek = startDayOfWeek;
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

    private void validateDate(int month, int date) {
        if (month % 2 == 1 && month < 8 && date > 31) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (month % 2 == 0 && month < 8 && date > 30) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (month % 2 == 1 && month > 7 && date > 30) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (month % 2 == 0 && month > 7 && date > 31) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
        if (month == 2 && date > 28) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public boolean isDayOff() {
        return dayOfWeek.isWeekend() || isHoliday();
    }

    private boolean isHoliday() {
        return isFirstHalfHoliday() || isSecondHalfHoliday();
    }

    private boolean isFirstHalfHoliday() {
        if (month == 1 && date == 1) {
            return true;
        }
        if (month == 3 && date == 1) {
            return true;
        }
        if (month == 5 && date == 5) {
            return true;
        }
        if (month == 6 && date == 6) {
            return true;
        }
        return false;
    }

    private boolean isSecondHalfHoliday() {
        if (month == 8 && date == 15) {
            return true;
        }
        if (month == 10 && (date == 3 || date == 9)) {
            return true;
        }
        if (month == 12 && date == 25) {
            return true;
        }
        return false;
    }

    public static Date getNextDay(Date date) {
        if (date.hasNextDay()) {
            return new Date(date.month, date.date + 1, DayOfWeek.getNext(date.dayOfWeek));
        }
        return null;
    }

    public boolean hasNextDay() {
        if (month <= 7) {
            if (month % 2 == 1) {
                return date < 31;
            }
            if (month == 2) {
                return date < 28;
            }
            return date < 30;
        }
        if (month % 2 == 0) {
            return date < 31;
        }
        return date < 30;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        if (isHoliday()) {
            return dayOfWeek.getDay() +"(휴일)";
        }
        return dayOfWeek.getDay();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date1 = (Date) o;
        return month == date1.month && date == date1.date && dayOfWeek == date1.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, date, dayOfWeek);
    }
}
