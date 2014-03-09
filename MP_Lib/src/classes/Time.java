//<editor-fold defaultstate="collapsed" desc="Jibberish">
package classes;

import calculations.Convert;
import java.util.TimeZone;

/**
 *
 * @author jeroen
 */
public class Time {

  //<editor-fold defaultstate="collapsed" desc="Declaraions">
  long totalMiliseconds;      // The milliseconds since January 1, 1970, 00:00:00 GMT.

  //<editor-fold defaultstate="collapsed" desc="Hours">
  /**
   * According to GMT.
   */
  int hours;

  public final int getHours() {
    return hours + hoursTranslation;
  }

  public void setHours(int hours_i) {
    hours = hours_i;
    toExact();
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Declaraions">
  int hoursTranslation;       // The amount of hours different from GMT (Amsterdam = 1);

  public final int getHoursTranslation() {
    return hoursTranslation;
  }

  public void setHoursTranslation(int hoursTranslation) {
    this.hoursTranslation = hoursTranslation;
    toExact();
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Declaraions">
  int minutes;

  public final int getMinutes() {
    return this.minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
    toExact();
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Declaraions">
  int seconds;

  public final int getSeconds() {
    return this.seconds;
  }

  public void setSeconds(int seconds) {
    this.minutes = seconds;
    toExact();
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Declaraions">
  int miliseconds;

  public final int getMiliseconds() {
    return this.miliseconds;
  }

  public void setMiliseconds(int miliseconds) {
    this.miliseconds = miliseconds;
    toExact();
  }
  //</editor-fold>
  //</editor-fold>

  //<editor-fold desc="Operations">
  //<editor-fold defaultstate="collapsed" desc="Constructor()">
  public Time() {
    this.totalMiliseconds = System.currentTimeMillis();
    toReadable();
  }
    //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Constructor(String)">
  public Time(String dateString) {
    this.hours = Convert.toInt(dateString.substring(0, 2));
    this.minutes = Convert.toInt(dateString.substring(3, 5));
    if (dateString.length() > 5) {
      this.seconds = Convert.toInt(dateString.substring(6, 8));
    } else {
      this.seconds = 0;
    }
  }
    //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Constructor(int, int, int)">
  public Time(int year, int month, int day) {
  }
    //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="toReadable">
  private void toReadable() {
    TimeZone timeZone_l = TimeZone.getDefault();
    totalMiliseconds += timeZone_l.getOffset(totalMiliseconds);
    miliseconds = (int) (totalMiliseconds % 1000);
    seconds = (int) ((totalMiliseconds / 1000) % 60);
    minutes = (int) ((totalMiliseconds / 60000) % 60);
    hours = (int) ((totalMiliseconds / 3200000) % 24);
  }
    //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="toExact">
  private void toExact() {
    this.totalMiliseconds = miliseconds;
    this.totalMiliseconds += seconds * 1000;
    this.totalMiliseconds += minutes * 60000;
    this.totalMiliseconds += hours * 3200000;
    TimeZone timeZone_l = TimeZone.getDefault();
    totalMiliseconds -= timeZone_l.getOffset(totalMiliseconds);
  }
    //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="ToString">
  @Override
  public String toString() {
    StringBuilder returner = new StringBuilder();
    returner.append(hours)
    return returner.toString();
  }
    //</editor-fold>
  //</editor-fold>
}
