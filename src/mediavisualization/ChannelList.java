package mediavisualization;

import java.util.Iterator;

public class ChannelList extends DoublyLinkedList<Channel> {
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
}
