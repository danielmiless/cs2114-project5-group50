package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The reader class takes the data from the input
 * files and employs other classes on that data.
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class Reader {

    private ChannelList channelList;

    /**
     * @field df Decimal Format for 0 value
     */
    private static final DecimalFormat df = new DecimalFormat("0.0");

    /**
     * Creates a new reader and sends a given file to be read.
     * 
     * @param fileName
     *                 The name of the file containing the channel data to be read.
     * @throws FileNotFoundException
     */
    public Reader(String fileName) throws FileNotFoundException {
        channelList = new ChannelList();
        readFile(fileName);
        intermediateSubmission();
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
                case "February":
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

    /**
     * print values for Web-cat reference tests
     */
    public void intermediateSubmission() {
        DoublyLinkedList<Channel> byName = channelList.sortByName(0, 2);
        Channel name1 = byName.get(0);
        Channel name2 = byName.get(1);
        Channel name3 = byName.get(2);
        Channel name4 = byName.get(3);
        
        String[] engagements = new String[4];
        for (int i = 0; i < 4; i++) {
            if (byName.get(i).getEngagement(0, 2) < 0) {
                engagements[i] = "N/A";
            }
            else {
                engagements[i] = df.format(byName.get(i).getEngagement(0, 2));
            }
        }
        
        DoublyLinkedList<Channel> byReach = channelList.sortByReach(0, 2);
        Channel reach1 = byReach.get(0);
        Channel reach2 = byReach.get(1);
        Channel reach3 = byReach.get(2);
        Channel reach4 = byReach.get(3);

        String[] reach = new String[4];
        for (int i = 0; i < 4; i++) {
            if (byReach.get(i).getReach(0, 2) < 0) {
                reach[i] = "N/A";
            }
            else {
                reach[i] = df.format(byReach.get(i).getReach(0, 2));
            }
        }
        
        System.out.println(name1.getChannelName());
        System.out.println("traditional: " + engagements[0]);
        System.out.println("==========");
        System.out.println(name2.getChannelName());
        System.out.println("traditional: " + engagements[1]);
        System.out.println("==========");
        System.out.println(name3.getChannelName());
        System.out.println("traditional: " + engagements[2]);
        System.out.println("==========");
        System.out.println(name4.getChannelName());
        System.out.println("traditional: " + engagements[3]);
        System.out.println("==========");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println(reach1.getChannelName());
        System.out.println("reach: " + reach[0]);
        System.out.println("==========");
        System.out.println(reach2.getChannelName());
        System.out.println("reach: " + reach[1]);
        System.out.println("==========");
        System.out.println(reach3.getChannelName());
        System.out.println("reach: " + reach[2]);
        System.out.println("==========");
        System.out.println(reach4.getChannelName());
        System.out.println("reach: " + reach[3]);
        System.out.println("==========");
    }
}