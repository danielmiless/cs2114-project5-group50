package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The reader class takes the data from the input
 * files and employs other classes on that data.
 */
public class Reader {

    private ChannelList channelList;

    /**
     * Creates a new reader and sends a given file to be read.
     * 
     * @param fileName
     *                 The name of the file containing the channel data to be read.
     * @throws FileNotFoundException
     */
    public Reader(String fileName) throws FileNotFoundException {
        readFile(fileName);
        channelList = new ChannelList();
    }

    /**
     * Extracts the data from each line of the provided file. Then, checks if the
     * channelList contains a channel with the same name. If a channel already
     * exists, adds the data to the appropriate month. If the channel doesn't exist,
     * creates a new channel, adds the month data, and adds the channel to the list.
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

            int month;
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
                    month = 0;
                    break;
                case "Febraury":
                    month = 1;
                    break;
                case "March":
                    month = 2;
                    break;
                case "April":
                    month = 3;
                    break;
                case "May":
                    month = 4;
                    break;
                case "June":
                    month = 5;
                    break;
                case "July":
                    month = 6;
                    break;
                case "August":
                    month = 7;
                    break;
                case "September":
                    month = 8;
                    break;
                case "October":
                    month = 9;
                    break;
                case "November":
                    month = 10;
                    break;
                case "December":
                    month = 11;
                    break;
                default:
                    month = -1; // Should handle ignoring invalid months in conjunction with if statement below.
                    break;
            }

            if (month > -1) {
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

                Channel channel = channelList.getChannel(channelName);
                if (channel == null) {
                    Channel newChannel = new Channel(username, channelName, country, mainTopic);
                    newChannel.setMonthData(month, likes, posts, followers, comments, views);
                    channelList.add(newChannel);
                } else {
                    channel.setMonthData(month, likes, posts, followers, comments, views);
                }
            }
        }
        scanner.close();
    }
}