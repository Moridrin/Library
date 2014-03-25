//<editor-fold defaultstate="collapsed" desc="Jibberish">

package formatting;

//</editor-fold>

import exceptions.UnknownLargeValue;
import exceptions.UnknownSmallValue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This enum is for the day of the week.
 *
 * @organization: Moridrin
 * @author        J.B.A.J. Berkvens
 * @date          2014/03/21
 */
public enum Day {
    
    //<editor-fold defaultstate="collapsed" desc="Declarations">
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;
    //</editor-fold>
    
    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="get(day)">
    /**
     * This operation returns a Day instance according to the day number.
     *
     * @param day the number of the day that will be returned.
     *
     * @return the day instance that corresponds with the given number.
     *
     * @throws UnknownLargeValue if the number given is greater than 7.
     * @throws UnknownSmallValue if the number given is smaller than 1.
     */
    public static Day get(int day) throws UnknownLargeValue, UnknownSmallValue {
        switch (day) {
            case 1:
                return Sunday;
            case 2:
                return Monday;
            case 3:
                return Tuesday;
            case 4:
                return Wednesday;
            case 5:
                return Thursday;
            case 6:
                return Friday;
            case 7:
                return Saturday;
            default:
                if (day > 7) {
                    throw new UnknownLargeValue("There is no day after 7");
                } else if (day < 1) {
                    throw new UnknownSmallValue("There is no day before 1");
                }
                return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getID()">
    /**
     * This operation returns the number of this day.
     *
     * @return the number of the day.
     */
    public int getID() {
        switch (this) {
            case Sunday:
                return 1;
            case Monday:
                return 2;
            case Tuesday:
                return 3;
            case Wednesday:
                return 4;
            case Thursday:
                return 5;
            case Friday:
                return 6;
            case Saturday:
                return 7;
            default:
                return 0;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getNext()">
    /**
     * this operation returns the Day instance of the next day.
     *
     * @return the next instance of Day. If the current day is December, the next instance is January).
     */
    public Day getNext() {
        if (this.getID() + 1 > 7) {
            return Sunday;
        } else {
            try {
                return Day.get(this.getID() + 1);
            } catch (UnknownSmallValue | UnknownLargeValue ex) {
                Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getPrevious()">
    /**
     * this operation returns the Day instance of the previous day.
     *
     * @return the previous instance of Day. If the current day is January, the previous instance is December).
     */
    public Day getPrevious() {
        if (this.getID() - 1 < 1) {
            return Saturday;
        } else {
            try {
                return Day.get(this.getID() - 1);
            } catch (UnknownLargeValue | UnknownSmallValue ex) {
                Logger.getLogger(Day.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
    //</editor-fold>
    //</editor-fold>
}
