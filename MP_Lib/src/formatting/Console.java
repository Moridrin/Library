//<editor-fold defaultstate="collapsed" desc="Jibberish">
package formatting;

import java.util.ArrayList;
//</editor-fold>

/**
 *
 * @author jeroen
 */
public class Console {

    public static void printTable(ArrayList<String[]> table) {
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
        for (String[] row : table) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println(" ");
        }
    }
}
