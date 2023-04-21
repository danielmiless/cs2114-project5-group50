package prj5;

/**
 * Compares the name of two Channel objects for use in a sort.
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class SortByName implements GenericCompare<Channel> {

    /**
     * compareTo method returning int value depending on comparison
     * @param o1 first object
     * @param o2 second object
     * @param start index for iteration
     * @param end index for iteration
     * @return int value depending on o1 and o2 values of name
     */
    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return o2.getChannelName().compareToIgnoreCase(o1.getChannelName());
    }
}
