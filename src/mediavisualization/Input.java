package mediavisualization;

import java.io.FileNotFoundException;

/**
 * The input class is used to run the java application.
 */
public class Input {
    /**
     * Initiates the program when ran by either passing the reader 
     * class the given filename from args, or by giving it the default filename.
     * 
     * @args
     *      File name for the file containing the influencer data
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            new Reader(args[0]);
        }
        else {
            new Reader("SampleInput1_2022.csv");
    }
}