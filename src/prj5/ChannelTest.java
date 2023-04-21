package prj5;

/**
 *
 */
public class ChannelTest extends student.TestCase {
    private Channel sports;
    private Channel empty;

    public void setUp() {
        sports = new Channel("SCentral", "SportsCentral", "US", "Sports");
        sports.setMonthData(0, 1, 2, 3, 4, 5);
        sports.setMonthData(1, 9, 8, 10, 6, 5);

        empty = new Channel("", "", "", "");
    }


    public void testSetAndGetMonthData() {
        assertNull(sports.getMonth()[2]);

        assertEquals(1, sports.getMonth()[0].getLikes());
        assertEquals(2, sports.getMonth()[0].getPosts());
        assertEquals(3, sports.getMonth()[0].getFollowers());
        assertEquals(4, sports.getMonth()[0].getComments());
        assertEquals(5, sports.getMonth()[0].getViews());

        sports.setMonthData(0, 10, 20, 30, 40, 50);
        assertEquals(10, sports.getMonth()[0].getLikes());
        assertEquals(20, sports.getMonth()[0].getPosts());
        assertEquals(30, sports.getMonth()[0].getFollowers());
        assertEquals(40, sports.getMonth()[0].getComments());
        assertEquals(50, sports.getMonth()[0].getViews());
    }


    public void testGetChannelName() {
        assertEquals("SportsCentral", sports.getChannelName());
    }


    public void testGetUsername() {
        assertEquals("SCentral", sports.getUsername());
    }


    public void testGetMainTopic() {
        assertEquals("Sports", sports.getMainTopic());
    }


    public void testGetCountry() {
        assertEquals("US", sports.getCountry());
    }


    public void testGetEngagement() {
        // End month is null
        assertEquals(-1.0, sports.getEngagement(0, 3), 0.1);

        // 1 month and multiple month, all data present
        assertEquals(166.7, sports.getEngagement(0, 0), 0.1);
        assertEquals(200.0, sports.getEngagement(0, 1), 0.1);

        // Multiple months, last month 0 followers
        sports.setMonthData(2, 10, 10, 0, 10, 10);
        assertEquals(-1.0, sports.getEngagement(0, 2), 0.1);

        // Empty list
        assertEquals(-1.0, empty.getEngagement(0, 1), 0.1);
        assertEquals(-1.0, empty.getEngagement(0, 0), 0.1);

        // Ignores empty month in the middle of list
        empty.setMonthData(0, 10, 10, 10, 10, 10);
        empty.setMonthData(2, 10, 10, 10, 10, 10);
        assertEquals(400.0, empty.getEngagement(0, 2), 0.1);
    }


    public void testGetReach() {
        // End month is null
        assertEquals(200.0, sports.getReach(0, 3), 0.1);

        // 1 month and multiple month, all data present
        assertEquals(100.0, sports.getReach(0, 0), 0.1);
        assertEquals(200.0, sports.getReach(0, 1), 0.1);

        // Empty list
        assertEquals(-1.0, empty.getReach(0, 1), 0.1);
        assertEquals(-1.0, empty.getReach(0, 0), 0.1);

        // Ignores empty month in the middle of list
        empty.setMonthData(0, 10, 10, 10, 10, 10);
        empty.setMonthData(2, 10, 10, 10, 10, 10);
        assertEquals(200.0, empty.getReach(0, 2), 0.1);

        // Zero views
        empty.setMonthData(0, 1, 1, 1, 1, 0);
        assertEquals(-1.0, empty.getReach(0, 0), 0.1);
    }
}
