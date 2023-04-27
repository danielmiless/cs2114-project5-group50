package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import student.TestableRandom;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * The GUI class contains all graphical user
 * interface elements and processes.
 * 
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
    private double[] values;

    /**
     * creates a new media visualization window
     * 
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
        values = new double[4];

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
        updateValues();// Need to call values first b/c other methods depend on the correct value

        updateBars();
        updateLabels();
        updateText();
    }

    public void updateBars() {
        window.removeAllShapes();

        // TODO: Fix sizing and window positioning
        // Also a lot of hard coding that could stand to be fixed
        bars[0] = new Shape((window.getWidth() / 8 - 10), (window.getHeight()
                / 2) - (int) values[0], 20, (int) values[0]);
        bars[1] = new Shape((2 * window.getWidth() / 8 - 10), (window
                .getHeight() / 2) - (int) values[1], 20, (int) values[1]);
        bars[2] = new Shape((3 * window.getWidth() / 8 - 10), (window
                .getHeight() / 2) - (int) values[2], 20, (int) values[2]);
        bars[3] = new Shape((4 * window.getWidth() / 8 - 10), (window
                .getHeight() / 2) - (int) values[3], 20, (int) values[3]);

        TestableRandom generator = new TestableRandom();
        bars[0].setBackgroundColor(new Color(generator.nextInt(256), generator
            .nextInt(256), generator.nextInt(256)));
        bars[1].setBackgroundColor(new Color(generator.nextInt(256), generator
            .nextInt(256), generator.nextInt(256)));
        bars[2].setBackgroundColor(new Color(generator.nextInt(256), generator
            .nextInt(256), generator.nextInt(256)));
        bars[3].setBackgroundColor(new Color(generator.nextInt(256), generator
            .nextInt(256), generator.nextInt(256)));

        window.addShape(bars[0]);
        window.addShape(bars[1]);
        window.addShape(bars[2]);
        window.addShape(bars[3]);
    }

    public void updateLabels() {
        // TODO: Display proper names under the bars
    }

    public void updateValues() {
        switch (engagementType) {
            case TRADITIONAL:
                for (int i = 0; i < 4; i++) {
                    values[i] = sortedList.get(i).getEngagement(startMonth,
                            endMonth);
                }
                break;
            default:
                for (int i = 0; i < 4; i++) {
                    values[i] = sortedList.get(i).getReach(startMonth,
                            endMonth);
                }
                break;
        }
    }

    public void updateText() {
        TextShape text1 = new TextShape(bars[0].getX(), bars[0].getY() + bars[0]
            .getHeight() + 5, sortedList.get(0).getChannelName(), Color.BLACK,
            10);
        TextShape text2 = new TextShape(bars[1].getX(), bars[1].getY() + bars[1]
            .getHeight() + 5, sortedList.get(1).getChannelName(), Color.BLACK,
            10);
        TextShape text3 = new TextShape(bars[2].getX(), bars[2].getY() + bars[2]
            .getHeight() + 5, sortedList.get(2).getChannelName(), Color.BLACK,
            10);
        TextShape text4 = new TextShape(bars[3].getX(), bars[3].getY() + bars[3]
            .getHeight() + 5, sortedList.get(3).getChannelName(), Color.BLACK,
            10);

        window.addShape(text1);
        window.addShape(text2);
        window.addShape(text3);
        window.addShape(text4);
        
        TextShape value1 = new TextShape(bars[0].getX(), bars[0].getY()
            + bars[0].getHeight() + text1.getHeight() + 5, df.format(values[0]), Color.BLACK, 10);
        TextShape value2 = new TextShape(bars[1].getX(), bars[1].getY()
            + bars[1].getHeight() + text2.getHeight() + 5, df.format(values[1]), Color.BLACK, 10);
        TextShape value3 = new TextShape(bars[2].getX(), bars[2].getY()
            + bars[2].getHeight() + text3.getHeight() + 5, df.format(values[2]), Color.BLACK, 10);
        TextShape value4 = new TextShape(bars[3].getX(), bars[3].getY()
            + bars[3].getHeight() + text4.getHeight() + 5, df.format(values[3]), Color.BLACK, 10);

        window.addShape(value1);
        window.addShape(value2);
        window.addShape(value3);
        window.addShape(value4);
    }

}
