//<editor-fold defaultstate="collapsed" desc="Jibberish">
package classes;

//</editor-fold>
/**
 * In this class you can find all properties and operations for Date. //CHECK
 * 
* @organization: Moridrin
 * @author J.B.A.J. Berkvens
 * @date //TODO
 */
public class Date {

	//<editor-fold defaultstate="collapsed" desc="Declarations">
    //<editor-fold defaultstate="collapsed" desc="Year">
    /**
     * The current year.
     */
    private int year;

    //<editor-fold defaultstate="collapsed" desc="setYear">
    public void setYear(int year) {
        this.year = year;
    }
	//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getYear">
    public int getYear() {
        return this.year;
    }
	//</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="month">
    /**
     * Number of the month (1-12).
     */
    private int month;

    //<editor-fold defaultstate="collapsed" desc="setMonth">
    public void setMonth(int month) {
        this.month = month;
    }
	//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getMonth">
    public int getMonth() {
        return this.month;
    }
	//</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="day">
    /**
     * The day of the month (1-31).
     */
    private int day;

    //<editor-fold defaultstate="collapsed" desc="setDay">
    public void setDay(int day) {
        this.day = day;
    }
	//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getDay">
    public int getDay() {
        return this.day;
    }
	//</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="century">
    /**
     * This is used to specify the amount of centuries after 1970 (in case of year=2071 century=1).
     */
    private int century;
	//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="totalMilliseconds">
    /**
     * The amount of milliseconds since 1-1-1970.
     */
    private long totalMilliseconds;
	//</editor-fold>
    //</editor-fold>

	//<editor-fold desc="Operations">
    //<editor-fold defaultstate="collapsed" desc="Constructor()">
    /**
     * This constructor creates a Date component with the current Date.
     */
    public Date() {
        day = 18;
    }
	//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor(, year, month, day)">
    /**
     * This constructor uses the given parameters to create a custom date.
     *
     * @param year  The year eg 2014.
     * @param month The month of the year (1-12).
     * @param day   The day of the month (1-31).
     */
    public Date(int year, int month, int day) {
        throw new UnsupportedOperationException();
    }
	//</editor-fold>
    //</editor-fold>
}
