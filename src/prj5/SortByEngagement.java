package prj5;

public class SortByEngagement implements GenericCompare<Channel> {
    @Override
    public int compare(Channel o1, Channel o2, int start, int end) {
        return o1.getEngagement(start, end) - o2.getEngagement(start, end);
    }
}
