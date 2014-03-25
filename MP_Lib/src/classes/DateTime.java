//<editor-fold defaultstate="collapsed" desc="Jibberish">
package classes;

//</editor-fold>
import exceptions.UnknownLargeValue;
import exceptions.UnknownSmallValue;

/**
 * In this class you can find all properties and operations for DateTime. //CHECK
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/03/25
 */
public class DateTime {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    private Date date;
    private Time time;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    //<editor-fold defaultstate="collapsed" desc="getDate()">
    public Date getDate() {
        return date;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setDate(date)">
    public void setDate(Date date) {
        this.date = date;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getTime()">
    public Time getTime() {
        return time;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setTime(time)">
    public void setTime(Time time) {
        this.time = time;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This is the constructor for DateTime. In here the DateTime will be set to the current date and time.
     */
    public DateTime() {
        date = new Date();
        time = new Time();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(dateString)">
    /**
     * This constructor uses the given String to create a custom date.
     *
     * @param dateTimeString for formatting see: http://Moridrin.com/java/mp_lib/datetime/default_formatting
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(String dateTimeString) throws UnknownSmallValue, UnknownLargeValue {
        this();
        String dateString = dateTimeString.split(" ")[0];
        if (dateString.contains("/")) {
            String[] dateParts = dateString.split("/");
            date.setDay(Integer.parseInt(dateParts[dateParts.length - 1]));
            date.setMonth(Integer.parseInt(dateParts[dateParts.length - 2]));
            if (dateParts.length >= 3) {
                date.setYear(Integer.parseInt(dateParts[dateParts.length - 3]));
            }
        } else if (dateString.contains("-")) {
            String[] dateParts = dateString.split("-");
            date.setMonth(Integer.parseInt(dateParts[dateParts.length - 1]));
            date.setDay(Integer.parseInt(dateParts[dateParts.length - 2]));
            if (dateParts.length >= 3) {
                date.setYear(Integer.parseInt(dateParts[dateParts.length - 3]));
            }
        }
        String timeString = dateTimeString.split(" ")[1];
        String[] timeParts = timeString.split(":");
        time.setHours(Integer.parseInt(timeParts[0]));
        time.setMinutes(Integer.parseInt(timeParts[1]));
        if (timeParts.length >= 3) {
            time.setSeconds(Integer.parseInt(timeParts[2]));
            if (timeString.length() == 4) {
                time.setMiliseconds(Integer.parseInt(timeParts[3]));
            } else {
                time.setSeconds(0);
            }
        } else {
            time.setSeconds(0);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(day)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param day The day of the month (1-31).
     *
     * @throws exceptions.UnknownLargeValue if the day is outside bounds.
     * @throws exceptions.UnknownSmallValue if the day is outside bounds.
     */
    public DateTime(int day) throws UnknownLargeValue, UnknownSmallValue {
        this(day, 1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(day, month)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param day   The day of the month (1-31).
     * @param month The month of the year (1-12).
     *
     * @throws exceptions.UnknownLargeValue if the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if the month is outside bounds.
     */
    public DateTime(int day, int month) throws UnknownLargeValue, UnknownSmallValue {
        this(day, month, 1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(day, month, year)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param day   The day of the month (1-31).
     * @param month The month of the year (1-12).
     * @param year  The year of the month (1-31).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(int day, int month, int year) throws UnknownLargeValue, UnknownSmallValue {
        this(day, month, year, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours)">
    /**
     * This constructor uses the given parameters to create a custom time.
     *
     * @param day   The day of the month (1-31).
     * @param month The month of the year (1-12).
     * @param year  The year of the month (1-31).
     * @param hours is the amount of hours spent of this year (0-23).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(int day, int month, int year, int hours) throws UnknownSmallValue, UnknownLargeValue {
        this(day, month, year, hours, 1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes)">
    /**
     * This constructor uses the given parameters to create a custom time.
     *
     * @param day     The day of the month (1-31).
     * @param month   The month of the year (1-12).
     * @param year    The year of the month (1-31).
     * @param hours   is the amount of hours spent of this year (0-23).
     * @param minutes is the amount of minutes spend in the hour (0-59).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(int day, int month, int year, int hours, int minutes) throws UnknownSmallValue, UnknownLargeValue {
        this(day, month, year, hours, minutes, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes, seconds)">
    /**
     * This constructor uses the given parameters to create a custom time.
     *
     * @param day     The day of the month (1-31).
     * @param month   The month of the year (1-12).
     * @param year    The year of the month (1-31).
     * @param hours   is the amount of hours spent of this year (0-23).
     * @param minutes is the amount of minutes spend in the hour (0-59).
     * @param seconds is the amount of seconds spend in the minute (0-59).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) throws UnknownSmallValue, UnknownLargeValue {
        this(day, month, year, hours, minutes, seconds, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes, seconds, milliseconds)">
    /**
     * This constructor uses the given parameters to create a custom time.
     *
     * @param day          The day of the month (1-31).
     * @param month        The month of the year (1-12).
     * @param year         The year of the month (1-31).
     * @param hours        is the amount of hours spent of this year (0-23).
     * @param minutes      is the amount of minutes spend in the hour (0-59).
     * @param seconds      is the amount of seconds spend in the minute (0-59).
     * @param milliseconds is the amount of milliseconds spend in the minute (0-999).
     *
     * @throws exceptions.UnknownLargeValue if ether the day or the month is outside bounds.
     * @throws exceptions.UnknownSmallValue if ether the day or the month is outside bounds.
     */
    public DateTime(int day, int month, int year, int hours, int minutes, int seconds, int milliseconds) throws UnknownSmallValue, UnknownLargeValue {
        date = new Date(day, month, year);
        time = new Time(hours, minutes, seconds, milliseconds);
    }
    //</editor-fold>

    //</editor-fold>
}
