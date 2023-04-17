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

    /**
     * Extracts the data from each line of the provided file. Then, creates a new
     * Channel object containing that data and adds it to the linked list containing
     * all channel objects.
     * 
     * @param fileName
     *                 The name of the file containing the channel data to be read.
     * @throws FileNotFoundException
     */
    public void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); // Skip the line containing headers

        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split(",\\s*");

            Month month;
            String username;
            String channelName;
            String country;
            String mainTopic;
            int likes;
            int posts;
            int followers;
            int comments;
            int views;

            switch (arr[0]) {
                case "January":
                    month = Month.JAN;
                    break;
                case "Febraury":
                    month = Month.FEB;
                    break;
                case "March":
                    month = Month.MAR;
                    break;
                case "April":
                    month = Month.APR;
                    break;
                case "May":
                    month = Month.MAY;
                    break;
                case "June":
                    month = Month.JUN;
                    break;
                case "July":
                    month = Month.JUL;
                    break;
                case "August":
                    month = Month.AUG;
                    break;
                case "September":
                    month = Month.SEP;
                    break;
                case "October":
                    month = Month.OCT;
                    break;
                case "November":
                    month = Month.NOV;
                    break;
                case "December":
                    month = Month.DEC;
                    break;
                default:
                    month = null; // Should handle ignoring invalid months in conjunction with if statement below.
                    break;
            }

            if (month != null) {
                username = arr[1];
                channelName = arr[2];
                if (arr.length == 10) {
                    country = arr[3];
                } else {
                    country = "";
                }
                mainTopic = arr[arr.length - 6];
                likes = Integer.valueOf(arr[arr.length - 5]);
                posts = Integer.valueOf(arr[arr.length - 4]);
                followers = Integer.valueOf(arr[arr.length - 3]);
                comments = Integer.valueOf(arr[arr.length - 2]);
                views = Integer.valueOf(arr[arr.length - 1]);

                // TODO When list is implemented, add channel to list.
                new Channel(month, username, channelName, country, mainTopic, likes, posts, followers, comments, views);
            }
        }
        scanner.close();
    }
}