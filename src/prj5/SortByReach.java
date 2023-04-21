package prj5;

/**
 * sort class by reach returning compareTo value
 * @author Austin Zary, Richard Nugyen, Daniel Miles
 * @version 2023.04.21
 */
public class SortByReach implements GenericCompare<Channel> {

    /**
     * CompareTo method returning < 0, > 0, = 0 for according
     * sort
     * @param o1 first object
     * @param o2 second object
     * @param start index for iteration
     * @param end index for iteration
     * @return int value depending on compared values
     */
    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return (int)(o1.getReach(start, end) - o2.getReach(start, end));
    }
}