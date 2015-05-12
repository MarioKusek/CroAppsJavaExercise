package hr.fer.croapps;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
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
        //System.out.println(content);

        String html = extractHtml(content);
        System.out.println(html);
    }

    private String extractHtml(String content) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            InputSource source = new InputSource();
            source.setCharacterStream(new StringReader(content));

            RssHandler handler = new RssHandler();

            saxParser.parse(source, handler);

            return handler.getString();
        } catch (Exception e) {
            throw new RuntimeException("Can not parse RSS!", e);
        }
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
