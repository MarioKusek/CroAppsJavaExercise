package hr.fer.croapps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
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
        String content = downloadContent();
        System.out.println(content);
    }

    private String downloadContent() {
        try {
            URL url = new URL(scheduleUrl);
            URLConnection connection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line = in.readLine();
            StringWriter sw = new StringWriter();
            while (line != null) {
                sw.write(line);
                sw.write("\n");
                line = in.readLine();
            }
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("Can not download schedule!", e);
        }
    }

    public List<ScheduleEntry> getList() {
        return list;
    }

    public void setList(List<ScheduleEntry> list) {
        this.list = list;
    }
}
