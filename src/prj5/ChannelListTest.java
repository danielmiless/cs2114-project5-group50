/**
 * 
 */
package prj5;

/**
 *  ChannelList Test using new channel linked list
 * @author Austin Zary, Richard Nguyen, Daniel Miles
 * @version 2023.04.21
 */
public class ChannelListTest extends student.TestCase {

    private ChannelList channels;

    /**
     * set up with new channelList
     */
    public void setUp() {
        channels = new ChannelList();
    }

    /**
     * add to list and getters tests
     */
    public void testAddAndGetChannel() {
        Channel chan1 = new Channel("first", "First", "US", "Stuff");
        Channel chan2 = new Channel("second", "Second", "US", "Things");
        Channel chan3 = new Channel("third", "Third", "EU", "Ideas");
        channels.add(chan1);
        assertEquals(chan1, channels.getChannel("First"));
        channels.add(chan2);
        channels.add(chan3);
        assertEquals(chan3, channels.getChannel("Third"));
        assertEquals(chan2, channels.getChannel("Second"));

        assertNull(channels.getChannel("NA"));
    }

    /**
     * name sort test with a,b,b named channel names
     */
    public void testSortByName() {
        Channel alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel bravo = new Channel("bravo", "bravo", "", "");
        Channel charlie = new Channel("charlie", "Charlie", "", "");

        channels.add(charlie);
        channels.add(alpha);
        channels.add(bravo);

        DoublyLinkedList<Channel> sorted = channels.sortByName(0, 0);

        assertEquals("Alpha", sorted.get(0).getChannelName());
        assertEquals("bravo", sorted.get(1).getChannelName());
        assertEquals("Charlie", sorted.get(2).getChannelName());
    }

    /**
     * engagement sort test with given engagement formula
     */
    public void testSortByEngagement() {
        Channel alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel bravo = new Channel("bravo", "bravo", "", "");
        Channel charlie = new Channel("charlie", "Charlie", "", "");

        alpha.setMonthData(0, 10, 10, 10, 10, 10);
        bravo.setMonthData(0, 10, 20, 0, 20, 0);
        charlie.setMonthData(0, 30, 30, 10, 30, 10);

        channels.add(bravo);
        channels.add(charlie);
        channels.add(alpha);

        DoublyLinkedList<Channel> sorted = channels.sortByEngagement(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("Alpha", sorted.get(1).getChannelName());
        assertEquals("bravo", sorted.get(2).getChannelName());
    }

    /**
     * sort by reach test with given reach formula
     */
    public void testSortByReach() {
        Channel alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel bravo = new Channel("bravo", "bravo", "", "");
        Channel charlie = new Channel("charlie", "Charlie", "", "");

        alpha.setMonthData(0, 10, 10, 10, 10, 10);
        bravo.setMonthData(0, 10, 20, 0, 20, 0);
        charlie.setMonthData(0, 30, 30, 10, 30, 10);

        channels.add(bravo);
        channels.add(charlie);
        channels.add(alpha);

        DoublyLinkedList<Channel> sorted = channels.sortByReach(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("Alpha", sorted.get(1).getChannelName());
        assertEquals("bravo", sorted.get(2).getChannelName());
    }

    /**
     * already sorted list to test no changes
     */
    public void testAlreadySortedList() {
        Channel alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel bravo = new Channel("bravo", "bravo", "", "");
        Channel charlie = new Channel("charlie", "Charlie", "", "");

        channels.add(alpha);
        channels.add(bravo);
        channels.add(charlie);

        DoublyLinkedList<Channel> sorted = channels.sortByName(0, 0);

        assertEquals("Alpha", sorted.get(0).getChannelName());
        assertEquals("bravo", sorted.get(1).getChannelName());
        assertEquals("Charlie", sorted.get(2).getChannelName());
    }
}
