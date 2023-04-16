package mediavisualization;

/**
 * The channel class which uses the DoublyLinkedList
 * to store the engagement objects.
 */
public class Channel extends DoublyLinkedList {
    // ~ Fields ................................................................

    private String month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ~ Constructor ...........................................................
    public Channel(String month, 
    String username, 
    String channelName, 
    String country, 
    String mainTopic, 
    int likes, 
    int posts, 
    int followers, 
    int comments, 
    int views) {
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

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
}
