package mediavisualization;

/**
 * Stores the data of a channel for each month.
 */
public class Months {

    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    /**
     * Creates a new month with the corresponding engagement data.
     * 
     * @param likes
     *                  The number of likes for the month.
     * @param posts
     *                  The number of posts for the month.
     * @param followers
     *                  The number of followers for the month.
     * @param comments
     *                  The number of comments for the month.
     * @param views
     *                  The number of views for the month.
     */
    public Months(int likes, int posts, int followers, int comments, int views) {
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }

    /**
     * Gets the number of likes for the month.
     * 
     * @return
     *         The number of likes for the month.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Gets the number of posts for the month.
     * 
     * @return
     *         The number of posts for the month.
     */
    public int getPosts() {
        return posts;
    }

    /**
     * Gets the number of followers for the month.
     * 
     * @return
     *         The number of followers for the month.
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * Gets the number of comments for the month.
     * 
     * @return
     *         The number of comments for the month.
     */
    public int getComments() {
        return comments;
    }

    /**
     * Gets the number of views for the month.
     * 
     * @return
     *         The number of views for the month.
     */
    public int getViews() {
        return views;
    }
}
