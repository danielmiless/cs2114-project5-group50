/**
 * 
 */
package prj5;

/**
 * 
 */
public class ChannelListTest extends student.TestCase {

    private ChannelList channels;

    public void setUp() {
        channels = new ChannelList();
    }


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


    public void testSortByName() {
        Channel Alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel Bravo = new Channel("bravo", "bravo", "", "");
        Channel Charlie = new Channel("charlie", "Charlie", "", "");

        channels.add(Charlie);
        channels.add(Alpha);
        channels.add(Bravo);

        DoublyLinkedList<Channel> sorted = channels.sortByName(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("bravo", sorted.get(1).getChannelName());
        assertEquals("Alpha", sorted.get(2).getChannelName());
    }


    public void testSortByEngagement() {
        Channel Alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel Bravo = new Channel("bravo", "bravo", "", "");
        Channel Charlie = new Channel("charlie", "Charlie", "", "");

        Alpha.setMonthData(0, 10, 10, 10, 10, 10);
        Bravo.setMonthData(0, 10, 20, 0, 20, 0);
        Charlie.setMonthData(0, 30, 30, 10, 30, 10);

        channels.add(Bravo);
        channels.add(Charlie);
        channels.add(Alpha);

        DoublyLinkedList<Channel> sorted = channels.sortByEngagement(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("Alpha", sorted.get(1).getChannelName());
        assertEquals("bravo", sorted.get(2).getChannelName());
    }
    
    public void testSortByReach() {
        Channel Alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel Bravo = new Channel("bravo", "bravo", "", "");
        Channel Charlie = new Channel("charlie", "Charlie", "", "");

        Alpha.setMonthData(0, 10, 10, 10, 10, 10);
        Bravo.setMonthData(0, 10, 20, 0, 20, 0);
        Charlie.setMonthData(0, 30, 30, 10, 30, 10);

        channels.add(Bravo);
        channels.add(Charlie);
        channels.add(Alpha);

        DoublyLinkedList<Channel> sorted = channels.sortByReach(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("Alpha", sorted.get(1).getChannelName());
        assertEquals("bravo", sorted.get(2).getChannelName());
    }
    
    public void testAlreadySortedList() {
        Channel Alpha = new Channel("alpha", "Alpha", "US", "Stuff");
        Channel Bravo = new Channel("bravo", "bravo", "", "");
        Channel Charlie = new Channel("charlie", "Charlie", "", "");

        channels.add(Alpha);
        channels.add(Bravo);
        channels.add(Charlie);

        DoublyLinkedList<Channel> sorted = channels.sortByName(0, 0);

        assertEquals("Charlie", sorted.get(0).getChannelName());
        assertEquals("bravo", sorted.get(1).getChannelName());
        assertEquals("Alpha", sorted.get(2).getChannelName());
    }
}
