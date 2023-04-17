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
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    public Channel(Month month,
            String username,
            String channelName,
            String country,
            String mainTopic,
            int likes,
            int posts,
            int followers,
            int comments,
            int views) {
        this.months = new Months[12];
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
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

    /**
     * 
     * @return
     *         The number of likes for this channel in the stored month.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * 
     * @return
     *         The number of posts for this channel in the stored month.
     */
    public int getPosts() {
        return posts;
    }

    /**
     * 
     * @return
     *         The number of followers for this channel in the stored month.
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * 
     * @return
     *         The number of comments for this channel in the stored month.
     */
    public int getComments() {
        return comments;
    }

    /**
     * 
     * @return
     *         The number of views for this channel in the stored month.
     */
    public int getViews() {
        return views;
    }
}
