package prj5;

/**
 * Compares the name of two Channel objects for use in a sort.
 */
public class sortByName implements GenericCompare<Channel> {
    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return o1.getChannelName().compareToIgnoreCase(o2.getChannelName());
    }
}
