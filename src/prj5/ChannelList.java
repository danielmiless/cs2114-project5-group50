package prj5;

import java.util.Iterator;

public class ChannelList {
    private DoublyLinkedList<Channel> channels;

    public ChannelList() {
        channels = new DoublyLinkedList<Channel>();
    }

    /**
     * Checks if the list contains a Channel with a specified channelName and
     * returns it. If there are no channels with a matching channel name, returns
     * null.
     * 
     * @param channelName
     *                    The channel name to check for.
     * @return The channel with matching channel name. Null if no matching channel.
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

    public DoublyLinkedList<Channel> sortByName(int start, int end) {
        channels.sort(new SortByName(), start, end);
        return channels;
    }


    public DoublyLinkedList<Channel> sortByEngagement(int start, int end) {
        channels.sort(new SortByEngagement(), start, end);
        return channels;
    }


    public DoublyLinkedList<Channel> sortByReach(int start, int end) {
        channels.sort(new SortByReach(), start, end);
        return channels;
    }

    public void add(Channel channel) {
        channels.add(channel);
    }
}
