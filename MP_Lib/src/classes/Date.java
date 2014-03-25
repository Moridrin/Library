//<editor-fold defaultstate="collapsed" desc="Jibberish">
package classes;

import exceptions.UnknownLargeValue;
import exceptions.UnknownSmallValue;
import formatting.Day;
import formatting.Month;
//</editor-fold>

/**
 * In this class you can find all properties and operations for Date.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/03/19
 */
public final class Date {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private int year;
    private int month;
    private int day;
    private int century;
    private long totalMilliseconds;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    //<editor-fold defaultstate="collapsed" desc="setYear">
    public void setYear(int year) {
        if (year < 100) {
            year = ((this.year / 100) * 100) + year;
            if (year < (this.year - 70)) {
                year += 100;
            } else if (year > this.year + 30) {
                year -= 100;
            }
        }
        this.year = year;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getYear">
    public int getYear() {
        return this.year;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setMonth">
    public void setMonth(int month) throws UnknownSmallValue, UnknownLargeValue {
        if (month > 12) {
            throw new UnknownLargeValue("There is no month greater than 12.");
        } else if (month < 1) {
            throw new UnknownSmallValue("There is no month smaller than 1.");
        } else {
            this.month = month;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMonth">
    public Month getMonth() {
        try {
            return Month.get(month);
        } catch (UnknownLargeValue | UnknownSmallValue ex) {
            //The code will never break here (the month value of this class can never be outside range).
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getMonthNumber">
    public int getMonthNumber() {
        return this.month;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setDay">
    public void setDay(int day) throws UnknownLargeValue {
        try {
            if (Month.get(month).getDays(year) < day) {
                throw new UnknownLargeValue("This month doesn't have " + day + " days.");
            } else if (day < 1) {
                throw new UnknownSmallValue("This month doesn't have " + day + " days.");
            } else {
                this.day = day;
            }
        } catch (UnknownLargeValue | UnknownSmallValue ex) {
            //The code will never break here (the day value of this class can never be outside range).
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getDay">
    public int getDay() {
        return this.day;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getDayOfTheWeek">
    public Day getDayOfTheWeek() {
        float totalDays = ((((totalMilliseconds / 1000) / 60) / 60) / 24);
        int dayOfTheWeek = 0;
        while (totalDays > 0) {
            dayOfTheWeek++;
            if (dayOfTheWeek > 7) {
                dayOfTheWeek = 1;
            }
        }
        try {
            return Day.get(dayOfTheWeek);
        } catch (UnknownLargeValue | UnknownSmallValue ex) {
            //The code will never break here (the modulo 7 class can never be outside range).
        } finally {
            //The code will never come here because it won't break.
            return Day.Friday;
        }
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for Date. In here the Date will be set to the current date.
     */
    public Date() {
        System.currentTimeMillis();
        toReadable();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(dateString)">
    /**
     * This constructor uses the given String to create a custom date.
     *
     * @param dateString for formatting see: http://Moridrin.com/java/mp_lib/date/default_formatting
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public Date(String dateString) throws UnknownSmallValue, UnknownLargeValue {
        this();
        if (dateString.contains("/")) {
            String[] dateParts = dateString.split("/");
            this.setDay(Integer.parseInt(dateParts[dateParts.length - 1]));
            this.setMonth(Integer.parseInt(dateParts[dateParts.length - 2]));
            if (dateParts.length >= 3) {
                this.setYear(Integer.parseInt(dateParts[dateParts.length - 3]));
            }
        } else if (dateString.contains("-")) {
            String[] dateParts = dateString.split("-");
            this.setMonth(Integer.parseInt(dateParts[dateParts.length - 1]));
            this.setDay(Integer.parseInt(dateParts[dateParts.length - 2]));
            if (dateParts.length >= 3) {
                this.setYear(Integer.parseInt(dateParts[dateParts.length - 3]));
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(year)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param year The year eg 2014.
     */
    public Date(int year) {
        try {
            this.setYear(year);
            this.setMonth(1);
            this.setDay(1);
        } catch (UnknownSmallValue | UnknownLargeValue ex) {
            //The code will never break here (the manual set variables are not outside range).
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(year, month)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param year  The year eg 2014.
     * @param month The month of the year (1-12).
     *
     * @throws exceptions.UnknownLargeValue if the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if the month is outside bounds.
     */
    public Date(int year, int month) throws UnknownLargeValue, UnknownSmallValue {
        this(year, month, 1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(year, month, day)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param year  The year eg 2014.
     * @param month The month of the year (1-12).
     * @param day   The day of the month (1-31).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public Date(int year, int month, int day) throws UnknownLargeValue, UnknownSmallValue {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        toExact();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toExact()">
    /**
     * This operation converts the values of the Years, Months, and Days to the exact amount of milliseconds since 1970.
     */
    private void toExact() {
        totalMilliseconds = yearToExact();
        totalMilliseconds += monthToExact();
        totalMilliseconds += dayToExact();
    }

    private long yearToExact() {
        long returner = 0;
        for (int i = 1970; i < year; i++) {
            if (isLeapYear(i)) {
                returner += 366 * 24 * 60 * 60 * 1000;
            }
        }
        return returner;
    }

    private long monthToExact() {
        long returner = 0;
        for (int i = 1; i < month; i++) {
            try {
                returner = Month.get(i).getDays(year) * 24 * 60 * 60 * 1000;
            } catch (UnknownLargeValue | UnknownSmallValue ex) {
                //The code will never break here (the month value of this class can never be outside range).
            }
        }
        return returner;
    }

    private long dayToExact() {
        long returner = 0;
        returner = day * 24 * 60 * 60 * 1000;
        return returner;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toReadable()">
    /**
     * This operation converts the exact amount of milliseconds since 1970 to the Years, Months, and Days.
     */
    private void toReadable() {
        yearToReadable();
        monthToReadable();
        dayToReadable();
    }

    private void yearToReadable() {
        year = 1970;
        long totalMillisecondsCalculate = totalMilliseconds;
        while (totalMillisecondsCalculate > 365 * 24 * 60 * 60 * 1000) {
            if (isLeapYear(year) && totalMillisecondsCalculate >= 366 * 24 * 60 * 60 * 1000) {
                totalMillisecondsCalculate -= 366 * 24 * 60 * 60 * 1000;
                year++;
            } else if (isLeapYear(year) && totalMillisecondsCalculate < 366 * 24 * 60 * 60 * 1000) {
                break;
            } else {
                totalMillisecondsCalculate -= 365 * 24 * 60 * 60 * 1000;
                year++;
            }
        }
    }

    private void monthToReadable() {
        try {
            month = 1;
            long totalMillisecondsCalculate = totalMilliseconds;
            while (totalMillisecondsCalculate > Month.get(month).getDays(year) * 24 * 60 * 60 * 1000) {
                totalMillisecondsCalculate -= Month.get(month).getDays(year) * 24 * 60 * 60 * 1000;
                month++;
            }
        } catch (UnknownLargeValue | UnknownSmallValue ex) {
        }
    }

    private void dayToReadable() {
        day = 1;
        long totalMillisecondsCalculate = totalMilliseconds;
        while (totalMillisecondsCalculate > 24 * 60 * 60 * 1000) {
            totalMillisecondsCalculate -= 24 * 60 * 60 * 1000;
            day++;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="isLeapYear(year)">
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="isBefore(date)">
    /**
     * This operation tests to see if this date is before the given date
     *
     * @param date is the date that is being tested.
     *
     * @return true if this date is before the date given.
     */
    public boolean isBefore(Date date) {
        if (this.year < date.year) {
            return true;
        } else if (this.year == date.year && this.month < date.month) {
            return true;
        } else if (this.year == date.year && this.month == date.month && this.day < date.day) {
            return true;
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(object)">
    /**
     * This operation checks if the given date is the same as this one.
     *
     * @param object is the date that will be checked.
     *
     * @return true if this date is the same as the given date.
     */
    @Override
    public boolean equals(Object object) {
        if (object.getClass().equals(this.getClass())) {
            return equals((Date) object);
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(date)">
    /**
     * This operation checks if the given date is the same as this one.
     *
     * @param date is the date that will be checked.
     *
     * @return true if this date is the same as the given date.
     */
    public boolean equals(Date date) {
        this.toExact();
        date.toExact();
        return (this.totalMilliseconds == date.totalMilliseconds);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toString()">
    /**
     * This operation gives a readable string of this instance.
     *
     * @return a readable string that represents this time.
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toString(format)">
    /**
     * This operation gives a readable string of this instance according to the given format.
     *
     * @param format see http://moridrin.com/java/mp_lib/date/formatting
     *
     * @return a readable string that represents this time.
     */
    public String toString(String format) {
        throw new UnsupportedOperationException();
    }
    //</editor-fold>
    //</editor-fold>
}
