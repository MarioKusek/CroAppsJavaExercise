package hr.fer.croapps;

import java.util.LinkedList;
import java.util.List;

public class HttpScheduleReader {
    private List<ScheduleEntry> list;
    private String scheduleUrl;

    public HttpScheduleReader() {
        list = new LinkedList<ScheduleEntry>();
        scheduleUrl = "http://www.fer.unizg.hr/feed/rss.php?portlet=scrollinfo";
    }

    // fetch data from net and populate list
    public void fetchSchedule() {

    }

    public List<ScheduleEntry> getList() {
        return list;
    }

    public void setList(List<ScheduleEntry> list) {
        this.list = list;
    }
}
