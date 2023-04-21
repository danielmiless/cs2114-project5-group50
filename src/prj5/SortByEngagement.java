package prj5;

/**
 * sort class by engagement returning compareTo value
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class SortByEngagement implements GenericCompare<Channel> {

    /**
     * compareTo method returning int value depending on comparison
     * @param o1 first object
     * @param o2 second object
     * @param start index for iteration
     * @param end index for iteration
     * @return int value based on compared engagement value
     */
    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return (int)(o1.getEngagement(start, end) -
                o2.getEngagement(start, end));
    }
}
