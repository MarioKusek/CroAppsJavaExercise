package hr.fer.croapps;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RssHandler extends DefaultHandler {
    private StringWriter sw = new StringWriter();
    private List<String> path = new LinkedList<String>();
    private List<String> expectedPath = Arrays.asList("rss", "channel", "item", "description");

    public String getString() {
        return sw.toString();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (path.equals(expectedPath)) {
            sw.write(ch, start, length);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        path.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        path.remove(path.size() - 1);
    }
}
