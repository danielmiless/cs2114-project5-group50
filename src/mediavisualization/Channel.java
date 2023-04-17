package mediavisualization;

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
     * Set month data.
     * 
     * @return
     */
    public void setMonthData(int month, int likes, int posts, int followers, int comments, int views) {
        months[month].setLikes(likes);
        months[month].setPosts(posts);
        months[month].setFollowers(followers);
        months[month].setComments(comments);
        months[month].setViews(views);
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
}