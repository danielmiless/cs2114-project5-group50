package mediavisualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The reader class takes the data from the input
 * files and employs other classes on that data.
 */
public class Reader {
    public Reader(String fileName) throws FileNotFoundException {
        readFile(fileName);
    }

    public void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split(",\\s*");
            Month month;
            switch (arr[0]) {
                case "January":
                    month = Month.JAN;
                case "Febraury":
                    month = Month.FEB;
                case "March":
                    month = Month.MAR;
                case "April":
                    month = Month.APR;
                case "May":
                    month = Month.MAY;
                case "June":
                    month = Month.JUN;
                case "July":
                    month = Month.JUL;
                case "August":
                    month = Month.AUG;
                case "September":
                    month = Month.SEP;
                case "October":
                    month = Month.OCT;
                case "November":
                    month = Month.NOV;
                case "December":
                    month = Month.DEC;
                default:
                    month = null;
            }

            if (month != null) {
                //TODO Finish implementing the reader here.
            }
        }
        scanner.close();
    }
}