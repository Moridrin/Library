/**********************\
* Moridrin Productions *
* Created by:          *
*      Jeroen Berkvens *
\**********************/
//<editor-fold defaultstate="collapsed" desc="Jibberish">
package calculations;

import classes.Date;
//</editor-fold>

/**
 * This class is responsible for converting.
 * Eg Text to numbers.
 *
 * @author jeroen
 */
public class Convert {

  public static int toInt(String string) throws NumberFormatException {
    int returner = 0;
    returner = Integer.parseInt(string);
    return returner;
  }

  public static Date currentDate() {
    Date returner = null;
    returner = new Date();
    return returner;
  }
}
