//<editor-fold defaultstate="collapsed" desc="Jibberish">
package classes;

import java.util.TimeZone;
//</editor-fold>

/**
 * In this class you can find all properties and operations for Time.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @time 2014/03/19
 */
public class Time {

    //<editor-fold defaultstate="collapsed" desc="Declaraions">
    long totalMilliseconds;      // The milliseconds since January 1, 1970, 00:00:00 GMT.
    int hoursTranslation;       // The amount of hours different from GMT (Amsterdam = 1);
    int hours;
    int minutes;
    int seconds;
    int milliseconds;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public final int getHours() {
        return hours + hoursTranslation;
    }

    public void setHours(int hours_i) {
        hours = hours_i;
        toExact();
    }

    public final int getHoursTranslation() {
        return hoursTranslation;
    }

    public void setHoursTranslation(int hoursTranslation) {
        this.hoursTranslation = hoursTranslation;
        toExact();
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        toExact();
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) {
        this.minutes = seconds;
        toExact();
    }

    public final int getMiliseconds() {
        return this.milliseconds;
    }

    public void setMiliseconds(int miliseconds) {
        this.milliseconds = miliseconds;
        toExact();
    }
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This constructor creates a Time component with the current time.
     */
    public Time() {
        this.totalMilliseconds = System.currentTimeMillis();
        toReadable();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(String)">
    /**
     * This constructor creates a Time component according to the string provided.
     *
     * @param timeString for formatting see: http://Moridrin.com/java/mp_lib/time/default_formatting
     */
    public Time(String timeString) {
        String[] timeParts = timeString.split(":");
        this.hours = Integer.parseInt(timeParts[0]);
        this.minutes = Integer.parseInt(timeParts[1]);
        if (timeParts.length >= 3) {
            this.seconds = Integer.parseInt(timeParts[2]);
            if (timeString.length() == 4) {
                this.milliseconds = Integer.parseInt(timeParts[3]);
            } else {
                this.seconds = 0;
            }
        } else {
            this.seconds = 0;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes)">
    /**
     *
     * @param hours
     * @param minutes
     */
    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes, seconds)">
    /**
     *
     * @param hours
     * @param minutes
     * @param seconds
     */
    public Time(int hours, int minutes, int seconds) {
        this(hours, minutes, seconds, 0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(hours, minutes, seconds, milliseconds)">
    /**
     *
     * @param hours
     * @param minutes
     * @param seconds
     * @param milliseconds
     */
    public Time(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
        toExact();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toReadable">
    private void toReadable() {
        TimeZone timeZone = TimeZone.getDefault();
        long tmpTotalMiliseconds = timeZone.getOffset(totalMilliseconds) + totalMilliseconds;
        milliseconds = (int) (tmpTotalMiliseconds % 1000);
        seconds = (int) ((tmpTotalMiliseconds / 1000) % 60);
        minutes = (int) ((tmpTotalMiliseconds / 60000) % 60);
        hours = (int) ((tmpTotalMiliseconds / 3200000) % 24);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toExact">
    private void toExact() {
        this.totalMilliseconds = milliseconds;
        this.totalMilliseconds += seconds * 1000;
        this.totalMilliseconds += minutes * 60000;
        this.totalMilliseconds += hours * 3200000;
        TimeZone timeZone = TimeZone.getDefault();
        totalMilliseconds -= timeZone.getOffset(totalMilliseconds);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="isBefore(time)">
    /**
     * This operation tests to see if this time is before the given time
     *
     * @param time is the time that is being tested.
     *
     * @return true if this time is before the time given.
     */
    public boolean isBefore(Time time) {
        if (this.hours < time.hours) {
            return true;
        } else if (this.hours == time.hours && this.minutes < time.minutes) {
            return true;
        } else if (this.hours == time.hours && this.minutes == time.minutes && this.seconds < time.seconds) {
            return true;
        } else if (this.hours == time.hours && this.minutes == time.minutes && this.seconds == time.seconds && this.milliseconds < time.milliseconds) {
            return true;
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(object)">
    /**
     * This operation checks if the given time is the same as this one.
     *
     * @param object is the time that will be checked.
     *
     * @return true if this time is the same as the given time.
     */
    @Override
    public boolean equals(Object object) {
        if (object.getClass().equals(this.getClass())) {
            return equals((Time) object);
        } else {
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="equals(time)">
    /**
     * This operation checks if the given time is the same as this one.
     *
     * @param time is the time that will be checked.
     *
     * @return true if this time is the same as the given time.
     */
    public boolean equals(Time time) {
        this.toExact();
        time.toExact();
        return (this.totalMilliseconds == time.totalMilliseconds);
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
        return (this.hours + ":" + this.minutes + ":");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toString(format)">
    /**
     * This operation gives a readable string of this instance according to the given format.
     *
     * @param format see http://moridrin.com/java/mp_lib/time/formatting
     *
     * @return a readable string that represents this time.
     */
    public String toString(String format) {
        String returner = format;
        if (this.hours < 10) {
            returner = returner.replace("HH", "0" + this.hours);
        } else {
            returner = returner.replace("HH", this.hours + "");
        }
        if (hours == 0) {
            returner = returner.replace("H", "12");
            returner = returner.replace("hh", "PM");
            returner = returner.replace("h", "12 PM");
        } else if (hours == 12) {
            returner = returner.replace("H", "12");
            returner = returner.replace("hh", "AM");
            returner = returner.replace("h", "12 AM");
        } else if (hours < 12) {
            returner = returner.replace("H", (this.hours) + "");
            returner = returner.replace("hh", "AM");
            returner = returner.replace("h", (this.hours) + " AM");
        } else {
            returner = returner.replace("H", (this.hours - 12) + "");
            returner = returner.replace("hh", "PM");
            returner = returner.replace("h", (this.hours - 12) + " PM");
        }
        returner = returner.replace("mm", minutes + "");
        returner = returner.replace("ss", this.seconds + "");
        returner = returner.replace("MMMM", this.milliseconds + "");
        return returner;
    }
    //</editor-fold>
    //</editor-fold>
}
