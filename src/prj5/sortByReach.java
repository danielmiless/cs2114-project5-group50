package prj5;

public class sortByReach implements GenericCompare<Channel> {

    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return (int)(o1.getReach(start, end) - o2.getReach(start, end));
    }
}