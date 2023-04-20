package prj5;

/**
 * The channel class which uses the DoublyLinkedList
 * to store the engagement objects.
 */
public class Channel {

    private Months[] months;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;

    public Channel(
            String username,
            String channelName,
            String country,
            String mainTopic) {
        this.months = new Months[12];
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
    }

    /**
     * Sets the engagement data for a given month.
     * 
     * @param month
     *                  The month which the data pertains to.
     * @param likes
     *                  The number of likes in the month.
     * @param posts
     *                  * The number of posts in the month.
     * @param followers
     *                  * The number of followers in the month.
     * @param comments
     *                  * The number of comments in the month.
     * @param views
     *                  * The number of views in the month.
     */
    public void setMonthData(int month, int likes, int posts, int followers, int comments, int views) {
        months[month] = new Months(likes, posts, followers, comments, views);
    }

    /**
     * 
     * @return
     *         The month associated with this channel.
     */
    public Months[] getMonth() {
        return months;
    }

    /**
     * 
     * @return
     *         The channel's name.
     */
    public String getChannelName() {
        return channelName;
    }

    public double getEngagement(int start, int end) {
        if (months[end] == null) {
            return -1; // Avoids nullPointers
        }
        double comments = 0;
        double likes = 0;
        double followers = (double) (months[end].getFollowers());
        if (followers == 0) {
            return -1; // Avoid dividing by zero
        }

        for (int i = start; i <= end; i++) {
            if (months[i] != null) {
                comments += (double) (months[i].getComments());
                likes += (double) (months[i].getLikes());
            }
        }

        return ((comments + likes) / followers) * 100;
    }

    public double getReach(int start, int end) {
        double comments = 0;
        double likes = 0;
        double views = 0;

        for (int i = start; i <= end; i++) {
            if (months[i] != null) {
                comments += (double) (months[i].getComments());
                likes += (double) (months[i].getLikes());
                views += (double) (months[i].getViews());
            }
        }

        if (views == 0) {
            return -1; // Avoid dividing by zero
        }
        return ((comments + likes) / views) * 100;
    }
}