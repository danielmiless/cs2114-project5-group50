package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;

/**
 * The GUI class contains all graphical user
 * interface elements and processes.
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class GUI {
    private Window window;
    private Reader reader;
    private Button quit;
    private Button sortEngagement;
    private Button sortChannelName;
    private Button traditionalEngagement;
    private Button reachEngagement;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;
    private static final double DISPLAY_FACTOR = 1.5;

    /**
     * creates a new media visualization window
     * @param reader a reader instance to pull sort
     *               data and channels from
     */
    public GUI(Reader reader) {
        window = new Window("Social Media Vis");
        window.setSize((int) (500 * DISPLAY_FACTOR), (int) (500 * DISPLAY_FACTOR));

        this.reader = reader;
        sortChannelName = new Button("Sort by Channel Name");
        sortEngagement = new Button("Sort by Engagement Rate");
        quit = new Button("Quit");
        window.addButton(sortChannelName, WindowSide.NORTH);
        window.addButton(sortEngagement, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
    }
}
