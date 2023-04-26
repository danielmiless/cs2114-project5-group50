package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * The GUI class contains all graphical user
 * interface elements and processes.
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class GUI {

    private static final DecimalFormat df = new DecimalFormat("0.0");

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
    private Sort sortType;
    private Sort engagementType;
    private int startMonth;
    private int endMonth;
    private DoublyLinkedList<Channel> sortedList;
    private Shape[] bars;

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
        sortChannelName.onClick(this, "clickedSortByChannel");
        sortEngagement = new Button("Sort by Engagement Rate");
        sortEngagement.onClick(this, "clickedSortByEngagement");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(sortChannelName, WindowSide.NORTH);
        window.addButton(sortEngagement, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);

        traditionalEngagement = new Button("Traditional Engagement Rate");
        traditionalEngagement.onClick(this, "clickedTradEngageRate");
        reachEngagement = new Button("Reach Engagement Rate");
        reachEngagement.onClick(this, "clickedReachEngageRate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        window.addButton(reachEngagement, WindowSide.WEST);

        january = new Button("January");
        january.onClick(this, "clickedJanuary");
        february = new Button("February");
        february.onClick(this, "clickedFebruary");
        march = new Button("March");
        march.onClick(this, "clickedMarch");
        firstQuarter = new Button("First Quarter(Jan - March)");
        firstQuarter.onClick(this, "clickedFirstQuarter");
        window.addButton(january, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(february, WindowSide.SOUTH);
        window.addButton(firstQuarter, WindowSide.SOUTH);

        bars = new Shape[4];

        sortType = Sort.NAME;
        engagementType = Sort.TRADITIONAL;
        startMonth = 0;
        endMonth = 2;
        updateWindow();
    }

    public void clickedQuit(Button button) {
        System.exit(0);
    }

    public void clickedJanuary(Button button) {
        startMonth = 0;
        endMonth = 0;
        updateWindow();
    }

    public void clickedFebruary(Button button) {
        startMonth = 1;
        endMonth = 1;
        updateWindow();
    }

    public void clickedMarch(Button button) {
        startMonth = 2;
        endMonth = 2;
        updateWindow();
    }

    public void clickedFirstQuarter(Button button) {
        startMonth = 0;
        endMonth = 2;
        updateWindow();
    }

    public void clickedSortByEngagement(Button button) {
        sortType = Sort.ENGAGEMENT;
        updateWindow();
    }

    public void clickedSortByChannel(Button button) {
        sortType = Sort.NAME;
        updateWindow();
    }

    public void clickedTradEngageRate(Button button) {
        engagementType = Sort.TRADITIONAL;
        updateWindow();
    }

    public void clickedReachEngageRate(Button button) {
        engagementType = Sort.REACH;
        updateWindow();
    }

    public void updateWindow() {
        switch (sortType) {
            case NAME:
                sortedList = reader.getChannelList().sortByName(startMonth,
                    endMonth);
                break;
            default:
                switch (engagementType) {
                    case TRADITIONAL:
                        sortedList = reader.getChannelList().sortByEngagement(
                            startMonth, endMonth);
                        break;
                    default:
                        sortedList = reader.getChannelList().sortByReach(
                            startMonth, endMonth);
                        break;
                }
                break;
        }
        updateBars();
        updateLabels();
        updateValues();
        updateText();
    }

    public void updateBars() {
        window.removeAllShapes();
        
        //TODO: Fix sizing and window positioning
        bars[0] = new Shape((window.getWidth() / 8 - 10), (window
            .getHeight() / 2) - (int)sortedList.get(0).getEngagement(startMonth,
                endMonth), 20, (int)sortedList.get(0).getEngagement(startMonth,
                    endMonth));
        bars[1] = new Shape((3 * window.getWidth() / 8 - 10), (window
            .getHeight() / 2) - (int)sortedList.get(1).getEngagement(startMonth,
                endMonth), 20, (int)sortedList.get(1).getEngagement(startMonth,
                    endMonth));
        bars[2] = new Shape((5 * window.getWidth() / 8 - 10), (window
            .getHeight() / 2) - (int)sortedList.get(2).getEngagement(startMonth,
                endMonth), 20, (int)sortedList.get(2).getEngagement(startMonth,
                    endMonth));
        bars[3] = new Shape((7 * window.getWidth() / 8 - 10), (window
            .getHeight() / 2) - (int)sortedList.get(3).getEngagement(startMonth,
                endMonth), 20, (int)sortedList.get(3).getEngagement(startMonth,
                    endMonth));

        window.addShape(bars[0]);
        window.addShape(bars[1]);
        window.addShape(bars[2]);
        window.addShape(bars[3]);
    }

    public void updateLabels() {

    }

    public void updateValues() {

    }

    public void updateText() {

    }

}
