package prj5;

/**
 * Interface for comparison classes
 * @param <T> type data to compare
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public interface GenericCompare<T> {

    /**
     * compare method returning values based on T comparison
     * @param o1 object 1
     * @param o2 object 2
     * @param start index for iteration
     * @param end index for iteration
     * @return int value depending on T value comparison
     */
    public int compare(T o1, T o2, int start, int end);
}
