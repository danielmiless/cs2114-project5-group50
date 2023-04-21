package prj5;

import java.util.Iterator;

/**
 * ChannelList class to hold channels in new doubly linked list
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class ChannelList {
    private DoublyLinkedList<Channel> channels;

    /**
     * Constructor declaring new empty doubly linked list
     */
    public ChannelList() {
        channels = new DoublyLinkedList<Channel>();
    }

    /**
     * Checks if the list contains a Channel
     * with a specified channelName and
     * returns it. If there are no channels
     * with a matching channel name, returns
     * null.
     * 
     * @param channelName
     *                    The channel name to check for.
     * @return The channel with matching channel name.
     * Null if no matching channel.
     */
    public Channel getChannel(String channelName) {
        Iterator<Channel> iter = channels.iterator();
        while (iter.hasNext()) {
            Channel curr = iter.next();
            if (curr.getChannelName().equals(channelName)) {
                return curr;
            }
        }
        return null;
    }

    /**
     * Calls sort method with name instance that returns compareTo,
     * also gives start and end index for iteration
     * @param start index for iteration
     * @param end index for iteration
     * @return sorted doubly linked list
     */
    public DoublyLinkedList<Channel> sortByName(int start, int end) {
        channels.sort(new SortByName(), start, end);
        return channels;
    }

    /**
     * Calls sort method with engagement instance that returns compareTo,
     * also gives start and end index for iteration
     * @param start index for iteration
     * @param end index for iteration
     * @return sorted doubly linked list
     */
    public DoublyLinkedList<Channel> sortByEngagement(int start, int end) {
        channels.sort(new SortByEngagement(), start, end);
        return channels;
    }

    /**
     * Calls sort method with engagement instance that returns compareTo,
     * also gives start and end index for iteration
     * @param start index for iteration
     * @param end index for iteration
     * @return sorted doubly linked list
     */
    public DoublyLinkedList<Channel> sortByReach(int start, int end) {
        channels.sort(new SortByReach(), start, end);
        return channels;
    }

    /**
     * adds channel to linked list
     * @param channel to be added to list
     */
    public void add(Channel channel) {
        channels.add(channel);
    }
}
