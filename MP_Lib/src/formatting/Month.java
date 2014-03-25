//<editor-fold defaultstate="collapsed" desc="Jibberish">
package formatting;

import exceptions.UnknownLargeValue;
import exceptions.UnknownSmallValue;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

/**
 * This enum is for the months in a year.
 *
 * @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date 2014/03/21
 */
public enum Month {

    //<editor-fold defaultstate="collapsed" desc="Declarations">
    January,
    February,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December;
    //</editor-fold>

    //<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="get(month)">
    /**
     * This operation returns a Month instance according to the month number.
     *
     * @param month the number of the month that will be returned.
     *
     * @return the month instance that corresponds with the given number.
     *
     * @throws UnknownLargeValue if the number given is greater than 12.
     * @throws UnknownSmallValue if the number given is smaller than 1.
     */
    public static Month get(int month) throws UnknownLargeValue, UnknownSmallValue {
        switch (month) {
            case 1:
                return January;
            case 2:
                return February;
            case 3:
                return March;
            case 4:
                return April;
            case 5:
                return May;
            case 6:
                return June;
            case 7:
                return July;
            case 8:
                return August;
            case 9:
                return September;
            case 10:
                return October;
            case 11:
                return November;
            case 12:
                return December;
            default:
                if (month > 12) {
                    throw new UnknownLargeValue("There is no month after 12");
                } else if (month < 1) {
                    throw new UnknownSmallValue("There is no month before 1");
                }
                return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getID()">
    /**
     * This operation returns the number of this month.
     *
     * @return the number of the month.
     */
    public int getID() {
        switch (this) {
            case January:
                return 1;
            case February:
                return 2;
            case March:
                return 3;
            case April:
                return 4;
            case May:
                return 5;
            case June:
                return 6;
            case July:
                return 7;
            case August:
                return 8;
            case September:
                return 9;
            case October:
                return 10;
            case November:
                return 11;
            case December:
                return 12;
            default:
                return 0;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getNext()">
    /**
     * this operation returns the Month instance of the next month.
     *
     * @return the next instance of Month. If the current month is December, the next instance is January).
     */
    public Month getNext() {
        if (this.getID() + 1 > 12) {
            return January;
        } else {
            try {
                return Month.get(this.getID() + 1);
            } catch (UnknownSmallValue | UnknownLargeValue ex) {
                Logger.getLogger(Month.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getPrevious()">
    /**
     * this operation returns the Month instance of the previous month.
     *
     * @return the previous instance of Month. If the current month is January, the previous instance is December).
     */
    public Month getPrevious() {
        if (this.getID() - 1 < 1) {
            return December;
        } else {
            try {
                return Month.get(this.getID() - 1);
            } catch (UnknownLargeValue | UnknownSmallValue ex) {
                Logger.getLogger(Month.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getDays(int year)">
    public int getDays(int year) {
        switch (this) {
            case January:
                return 31;
            case February:
                if (year % 4 == 0) {
                    if (year % 100 == 0 && year % 400 != 0) {
                        return 28;
                    } else {
                        return 29;
                    }
                } else {
                    return 28;
                }
            case March:
                return 31;
            case April:
                return 30;
            case May:
                return 31;
            case June:
                return 30;
            case July:
                return 31;
            case August:
                return 31;
            case September:
                return 30;
            case October:
                return 31;
            case November:
                return 30;
            case December:
                return 31;
            default:
                return 0;
        }
    }
    //</editor-fold>
}
