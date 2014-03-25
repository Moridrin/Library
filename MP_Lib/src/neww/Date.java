//<editor-fold defaultstate="collapsed" desc="Jibberish">
package neww;

//</editor-fold>
/**
* In this class you can find all properties and operations for Date.
* //CHECK
*
* @organization: Moridrin
* @author        J.B.A.J. Berkvens
* @date          //TODO
*/
public class Date {

	//<editor-fold defaultstate="collapsed" desc="Declarations">
	/**
	 * The current year.
	 */
	private int year;
	/**
	 * Number of the month (1-12).
	 */
	private int month;
	/**
	 * The day of the month (1-31).
	 */
	private int day;
	/**
	 * This is used to specify the amount of centuries after 1970 (in case of year=2071 century=1).
	 */
	private int century;
	/**
	 * The amount of milliseconds since 1-1-1970.
	 */
	private long totalMilliseconds;
	//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
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

	//<editor-fold desc="Operations">
	//<editor-fold defaultstate="collapsed" desc="Constructor()">
	/**
	 * This constructor creates a Date component with the current Date.
	 */
	public Date() {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Constructor(, year)">
	/**
	 * This constructor uses the given parameters to create a custom date.
	 * @param year The year eg 2014.
	 */
	public Date(int year) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Constructor(, year, month)">
	/**
	 * This constructor uses the given parameters to create a custom date.
	 * @param year The year eg 2014.
	 * @param month The month of the year (1-12).
	 */
	public Date(int year, int month) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Constructor(, year, month, day)">
	/**
	 * This constructor uses the given parameters to create a custom date.
	 * @param year The year eg 2014.
	 * @param month The month of the year (1-12).
	 * @param day The day of the month (1-31).
	 */
	public Date(int year, int month, int day) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="toExact">
	/**
	 * This operation converts the values of the Years, Months, and Days to the exact amount of milliseconds since 1970.
	 */
	private void toExact() {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="toReadable">
	/**
	 * This operation converts the exact amount of milliseconds since 1970 to the Years, Months, and Days.
	 */
	private void toReadable() {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="isBefore">
	/**
	 * This operation tests to see if this date is before the given date
	 * @param date is the date that is being tested.
	 */
	public boolean isBefore(Date date) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="equals">
	/**
	 * This operation checks if the given date is the same as this one.
	 * @param date is the date that will be checked.
	 */
	public boolean equals(Date date) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="toString">
	/**
	 * This operation gives a readable string of this instance.
	 */
	public String toString() {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="toString">
	/**
	 * This operation gives a readable string of this instance according to the given format.
	 */
	public String toString(String format) {
		throw new UnsupportedOperationException();
	}
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="Equals(date)">
	@Override
	public boolean equals(Object object){
		if (this == object) {
			return true;
		} else if (object instanceof Date) {
			Date dateObject = (Date) object;
			boolean equals = true;
			equals &= this.year == dateObject.year;
			equals &= this.month == dateObject.month;
			equals &= this.day == dateObject.day;
			equals &= this.century == dateObject.century;
			equals &= this.totalMilliseconds == dateObject.totalMilliseconds;
			return equals;
		}
		return false;
        }
	//</editor-fold>
}