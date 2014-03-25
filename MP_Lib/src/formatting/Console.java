//<editor-fold defaultstate="collapsed" desc="Jibberish">
package formatting;

import java.util.ArrayList;
//</editor-fold>

/**
 *
 * @author jeroen
 */
public class Console {

    //<editor-fold defaultstate="collapsed" desc="Print Table">
    public static void printTable(ArrayList<String[]> table) {
        //<editor-fold defaultstate="collapsed" desc="Determin the size of each column">
        int[] largestSizeInColumn = new int[table.get(1).length];
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                String[] row = table.get(i);
                for (int j = 0; j < row.length; j++) {
                    String cell = row[j];
                    if (cell.length() > largestSizeInColumn[j]) {
                        largestSizeInColumn[j] = cell.length();
                    }
                }
            }
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Make all Cells fit.">
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                String[] row = table.get(i);
                for (int j = 0; j < row.length; j++) {
                    String cell = row[j];
                    while (cell.length() < largestSizeInColumn[j]) {
                        cell += " ";
                    }
                    cell += " ";
                    row[j] = cell;
                }
            }
            //</editor-fold>
            
        //<editor-fold defaultstate="collapsed" desc="Add lined rows">
            else{
                String[] row = new String[table.get(1).length];
                for (int j = 0; j < row.length; j++) {
                    String cell = "";
                    while (cell.length() < largestSizeInColumn[j]) {
                        cell += "-";
                    }
                    cell += "-";
                    row[j] = cell;
                }
                table.set(i, row);
            }

        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Print Table">
        for (String[] row : table) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println(" ");
        }
        //</editor-fold>
    }
}
