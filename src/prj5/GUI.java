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
        window.setSize(700, 500);

        this.reader = reader;
        sortChannelName = new Button("Sort by Channel Name");
        sortEngagement = new Button("Sort by Engagement Rate");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(sortChannelName, WindowSide.NORTH);
        window.addButton(sortEngagement, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);

        traditionalEngagement = new Button("Traditional Engagement Rate");
        reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        window.addButton(reachEngagement, WindowSide.WEST);

        january = new Button("January");
        february = new Button("February");
        march = new Button("March");
        firstQuarter = new Button("First Quarter(Jan - March)");
        window.addButton(january, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(february, WindowSide.SOUTH);
        window.addButton(firstQuarter, WindowSide.SOUTH);
    }

    public void clickedQuit(Button button) {
        System.exit(0);
    }

    public void clickedJanuary(Button button) {

    }

    public void clickedFebruary(Button button) {

    }

    public void clickedMarch(Button button) {

    }

    public void clickedFirstQuarter(Button button) {

    }

    public void clickedSortByEngagement(Button button) {

    }

    public void clickedSortByChannel(Button button) {

    }

    public void clickedTradEngageRate(Button button) {

    }

    public void clickedReachEngageRate(Button button) {

    }

}
