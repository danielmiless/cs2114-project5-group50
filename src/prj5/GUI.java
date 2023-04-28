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
    private String monthText;
    private String sortText;
    private String engagementText;

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
        window.addButton(february, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(firstQuarter, WindowSide.SOUTH);

        bars = new Shape[4];
        values = new double[4];

        sortType = Sort.NAME; //Initial conditions
        engagementType = Sort.TRADITIONAL;
        startMonth = 0;
        endMonth = 2;
        monthText = "First Quarter (Jan-March)";
        sortText = "Sorting by Channel Name";
        engagementText = "Traditional Engagement Rate";

        updateWindow();
    }

    /**
     * closes the window when the quit button is clicked
     * 
     * @param button the button that was clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * shows only the data from january
     * 
     * @param button the button that was clicked
     */
    public void clickedJanuary(Button button) {
        startMonth = 0;
        endMonth = 0;
        monthText = "January";
        updateWindow();
    }

    /**
     * shows only the data from february
     * 
     * @param button the button that was clicked
     */
    public void clickedFebruary(Button button) {
        startMonth = 1;
        endMonth = 1;
        monthText = "February";
        updateWindow();
    }

    /**
     * shows only the data from march
     * 
     * @param button the button that was clicked
     */
    public void clickedMarch(Button button) {
        startMonth = 2;
        endMonth = 2;
        monthText = "March";
        updateWindow();
    }

    /**
     * shows only the data from the first quarter
     * 
     * @param button the button that was clicked
     */
    public void clickedFirstQuarter(Button button) {
        startMonth = 0;
        endMonth = 2;
        monthText = "First Quarter (Jan-Mar)";
        updateWindow();
    }

    /**
     * sorts the data by engagement rate
     * 
     * @param button the button that was clicked
     */
    public void clickedSortByEngagement(Button button) {
        sortType = Sort.ENGAGEMENT;
        sortText = "Sorting by Engagement Rate";
        updateWindow();
    }

    /**
     * sorts the data by channel name
     * 
     * @param button the button that was clicked
     */
    public void clickedSortByChannel(Button button) {
        sortType = Sort.NAME;
        sortText = "Sorting by Channel Name";
        updateWindow();
    }

    /**
     * sorts the data by traditional engagement rate
     * 
     * @param button the button that was clicked
     */
    public void clickedTradEngageRate(Button button) {
        engagementType = Sort.TRADITIONAL;
        engagementText = "Traditional Engagement Rate";
        updateWindow();
    }

    /**
     * sorts the data by reach engagement rate
     * 
     * @param button the button that was clicked
     */
    public void clickedReachEngageRate(Button button) {
        engagementType = Sort.REACH;
        engagementText = "Reach Engagement Rate";
        updateWindow();
    }

    /**
     * updates the window with the new data
     */
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
        updateValues();// Need to call values first b/c other methods depend on the new value
        updateBars();
        updateLabels();
        updateText();
    }

    /**
     * updates the bars on the window
     */
    public void updateBars() {
        window.removeAllShapes();
        
        TestableRandom generator = new TestableRandom();
        
        for (int i = 0; i < 4; i++) {
            bars[i] = new Shape(((i + 1) * window.getWidth() / 8 - 10),
             (window.getHeight() / 2) - (int) values[i], 20, (int) values[i]);
            bars[i].setBackgroundColor(new Color(generator.nextInt(256),
             generator.nextInt(256), generator.nextInt(256)));
            
            window.addShape(bars[i]);
        }
    }

    /**
     * updates the labels on the window
     */
    public void updateLabels() {
        TextShape monthLabel = new TextShape(5, 5, monthText, Color.BLACK, 12);
        TextShape engagementLabel = new TextShape(5, monthLabel.getY()
            + monthLabel.getHeight() + 5, engagementText, Color.BLACK, 12);
        TextShape sortLabel = new TextShape(5, engagementLabel.getY()
            + engagementLabel.getHeight() + 5, sortText, Color.BLACK, 12);

        window.addShape(monthLabel);
        window.addShape(engagementLabel);
        window.addShape(sortLabel);
    }

    /**
     * updates the values of the bars
     */
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

    /**
     * updates the text on the window
     */
    public void updateText() {
        TextShape[] channelsText = new TextShape[4];
        TextShape[] valuesText = new TextShape[4];

        for (int i = 0; i < 4; i++) {
            channelsText[i] = new TextShape(bars[i].getX(), bars[i].getY()
                + bars[i].getHeight() + 5, sortedList.get(i).getChannelName(),
                Color.BLACK, 15);
            valuesText[i] = new TextShape(bars[i].getX(), bars[i].getY()
                + bars[i].getHeight() + channelsText[i].getHeight() + 5, "",
                Color.BLACK, 15);
            if (values[i] < 0) {
                valuesText[i].setText("N/A");
            }
            else {
                valuesText[i].setText(df.format(values[i]));
            }
            window.addShape(channelsText[i]);
            window.addShape(valuesText[i]);
        }
    }
}
