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

    public Months() {
    }

    public void setLikes(int newLikes) {
        likes = newLikes;
    }

    public void setPosts(int newPosts) {
        posts = newPosts;
    }

    public void setFollowers(int newFollowers) {
        followers = newFollowers;
    }

    public void setComments(int newComments) {
        comments = newComments;
    }

    public void setViews(int newViews) {
        views = newViews;
    }

    public int getLikes() {
        return likes;
    }

    public int getPosts() {
        return posts;
    }

    public int getFollowers() {
        return followers;
    }

    public int getComments() {
        return comments;
    }

    public int getViews() {
        return views;
    }
}
